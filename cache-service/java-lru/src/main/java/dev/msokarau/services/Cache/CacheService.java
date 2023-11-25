package dev.msokarau.services.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheService {
  private static final int MAX_ITEMS = 100000;
  private static final long EVICTION_TIME_THRESHOLD = 5000; // 5 seconds

  private final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();
  private final ScheduledExecutorService evictionScheduler = Executors.newScheduledThreadPool(4);

  private long totalPutTime = 0;
  private int totalEvictions = 0;
  private int totalPutItems = 0;

  public CacheService() {
    // Schedule periodic eviction task
    evictionScheduler.scheduleAtFixedRate(this::evictStaleEntries, 1, 1, TimeUnit.SECONDS);
  }

  public void put(String key, String value) {
    long startTime = System.nanoTime();

    // Ensure the cache does not exceed the maximum size
    if (cache.size() >= MAX_ITEMS) {
      evictStaleEntries();
    }
    if (cache.size() >= MAX_ITEMS) {
      // Still too many items, evict the first one
      String firstKey = cache.keySet().iterator().next();
      cache.remove(firstKey);
      totalEvictions++;
      // logEviction(firstKey); // Disabled to reduce console output
    }

    cache.put(key, new CacheEntry(value));
    totalPutItems++;

    long endTime = System.nanoTime();
    totalPutTime += (endTime - startTime);
  }

  public String get(String key) {
    CacheEntry entry = cache.get(key);
    return (entry != null) ? entry.getValue() : null;
  }

  public long getAveragePutTime() {
    if (totalPutItems == 0) {
      return 0;
    }

    return totalPutTime / totalPutItems;
  }

  public long getEvictionCount() {
    return totalEvictions;
  }

  public void shutdown() {
    evictionScheduler.shutdown();
  }

  public void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void evictStaleEntries() {
    long currentTime = System.currentTimeMillis();
    int evictedThisRun = 0;

    for (Map.Entry<String, CacheEntry> entry : cache.entrySet()) {
      String key = entry.getKey();
      CacheEntry cacheEntry = entry.getValue();

      if (currentTime - cacheEntry.getLastAccessTime() > EVICTION_TIME_THRESHOLD) {
        // Entry is stale, evict it
        cache.remove(key);
        totalEvictions++;
        evictedThisRun++;
        // logEviction(key); // Disabled to reduce console output
      }
    }

    if (evictedThisRun > 0) {
      System.out.println("> Evicted " + evictedThisRun + " entries");
    }
  }

  private void logEviction(String key) {
    System.out.println("- " + key);
  }
}
