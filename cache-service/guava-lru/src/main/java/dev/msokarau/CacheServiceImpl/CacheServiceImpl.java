package dev.msokarau.CacheServiceImpl;

import com.google.common.cache.*;

import dev.msokarau.CacheEntryImpl.CacheEntryImpl;
import dev.msokarau.ConfigImpl.ConfigImpl;
import dev.msokarau.interfaces.CacheService.CacheService;
import dev.msokarau.interfaces.CacheEntry.CacheEntry;
import dev.msokarau.interfaces.Config.Config;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {
  private final Cache<String, CacheEntry> cache;

  private long totalPutTime = 0;
  private int totalEvictions = 0;
  private int totalPutItems = 0;

  public CacheServiceImpl() {
    this(new ConfigImpl());
  }

  public CacheServiceImpl(Config config) {
    cache = CacheBuilder.newBuilder()
        .maximumSize(config.getMaxItems())
        .expireAfterAccess(config.getEvictionTime(), TimeUnit.MILLISECONDS)
        .removalListener((RemovalNotification<String, CacheEntry> notification) -> {
          totalEvictions++;
          logEviction(notification.getKey());
        })
        .build();
  }

  public String get(String key) {
    CacheEntry entry = cache.getIfPresent(key);

    if (entry == null) {
      return null;
    }

    return entry.getValue();
  }

  public void put(String key, String value) {
    long start = System.nanoTime();
    cache.put(key, new CacheEntryImpl(value));
    long end = System.nanoTime();

    totalPutTime += (end - start);
    totalPutItems++;
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
    cache.invalidateAll();
  }

  private void logEviction(String key) {
    System.out.println("- " + key);
  }
}
