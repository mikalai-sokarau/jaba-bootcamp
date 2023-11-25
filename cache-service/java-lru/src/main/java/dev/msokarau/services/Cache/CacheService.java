package dev.msokarau.services.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheService {
  private Config config;

  private final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();
  private final ScheduledExecutorService evictionScheduler = Executors.newScheduledThreadPool(4);

  private long totalPutTime = 0;
  private int totalEvictions = 0;
  private int totalPutItems = 0;

  public CacheService() {
    this(new Config());
  }

  public CacheService(Config config) {
    this.config = config;
    // Schedule periodic eviction task
    evictionScheduler.scheduleAtFixedRate(this::evictStaleEntries, 1, config.getEvictionPeriod(),
        TimeUnit.MILLISECONDS);
  }

  public void put(String key, String value) {
    long startTime = System.nanoTime();

    // Ensure the cache does not exceed the maximum size
    if (cache.size() >= config.getMaxItems()) {
      evictStaleEntries();
    }
    if (cache.size() >= config.getMaxItems()) {
      // Still too many items, evict the first one
      String firstKey = cache.keySet().iterator().next();
      cache.remove(firstKey);
      totalEvictions++;
      logEviction(firstKey);
    }

    cache.put(key, new CacheEntry(value));
    totalPutItems++;

    long endTime = System.nanoTime();
    totalPutTime += (endTime - startTime);
  }

  public String get(String key) {
    CacheEntry entry = cache.get(key);

    if (entry == null) {
      return null;
    }

    return entry.getValue();
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

  private void evictStaleEntries() {
    long currentTime = System.currentTimeMillis();
    int evictedThisRun = 0;

    for (Map.Entry<String, CacheEntry> entry : cache.entrySet()) {
      String key = entry.getKey();
      CacheEntry cacheEntry = entry.getValue();

      if (currentTime - cacheEntry.getLastAccessTime() > config.getEvictionTime()) {
        // Entry is stale, evict it
        cache.remove(key);
        totalEvictions++;
        evictedThisRun++;
        logEviction(key); // Disabled to reduce console output
      }
    }

    if (evictedThisRun > 0) {
      System.out.println("> Evicted " + evictedThisRun + " entries\n");
    }
  }

  private void logEviction(String key) {
    // System.out.println("- " + key); // Disabled to reduce console output
  }
}
