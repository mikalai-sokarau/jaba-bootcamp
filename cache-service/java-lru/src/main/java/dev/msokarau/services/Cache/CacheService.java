package dev.msokarau.services.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheService {
  private static final int MAX_ITEMS = 100; // can be set to 100000, but console output is too huge ^^
  private static final long EVICTION_TIME_THRESHOLD = 5000; // 5 seconds

  private final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();
  private final ScheduledExecutorService evictionScheduler = Executors.newScheduledThreadPool(4);

  private long totalPutTime = 0;
  private long totalEvictions = 0;

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
    // Still too many items, evict the first one
    if (cache.size() >= MAX_ITEMS) {
      String firstKey = cache.keySet().iterator().next();
      cache.remove(firstKey);
      totalEvictions++;
      logEviction(firstKey);
    }

    cache.put(key, new CacheEntry(value));

    long endTime = System.nanoTime();
    totalPutTime += (endTime - startTime);
  }

  public String get(String key) {
    CacheEntry entry = cache.get(key);
    return (entry != null) ? entry.getValue() : null;
  }

  public long getAveragePutTime() {
    return (cache.size() > 0) ? totalPutTime / cache.size() : 0;
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

    for (Map.Entry<String, CacheEntry> entry : cache.entrySet()) {
      String key = entry.getKey();
      CacheEntry cacheEntry = entry.getValue();

      if (currentTime - cacheEntry.getLastAccessTime() > EVICTION_TIME_THRESHOLD) {
        // Entry is stale, evict it
        cache.remove(key);
        totalEvictions++;
        logEviction(key);
      }
    }
  }

  private void logEviction(String key) {
    System.out.println("- " + key);
  }
}
