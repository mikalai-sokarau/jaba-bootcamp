package dev.msokarau.CacheServiceImpl;

import com.google.common.cache.*;

import dev.msokarau.CacheEntryImpl.CacheEntryImpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import dev.msokarau.interfaces.CacheEntry.CacheEntry;

public class CacheServiceImpl {
  private final LoadingCache<String, CacheEntry> cache;
  private final AtomicLong totalPutTime = new AtomicLong();
  private final AtomicLong putCount = new AtomicLong();

  public CacheServiceImpl() {
    cache = CacheBuilder.newBuilder()
        .maximumSize(100_000)
        .expireAfterAccess(5, TimeUnit.SECONDS)
        .removalListener((RemovalNotification<String, CacheEntry> notification) -> {
          System.out.println("Removed " + notification.getKey());
        })
        .recordStats()
        .build(
            new CacheLoader<String, CacheEntry>() {
              public CacheEntry load(String key) {
                return new CacheEntryImpl(key);
              }
            });
  }

  public CacheEntry get(String key) {
    return cache.getUnchecked(key);
  }

  public void put(String key, String value) {
    long start = System.nanoTime();
    cache.put(key, new CacheEntryImpl(value));
    long end = System.nanoTime();
    totalPutTime.addAndGet(end - start);
    putCount.incrementAndGet();
  }

  public double getAveragePutTime() {
    return totalPutTime.get() / (double) putCount.get();
  }

  public long getEvictionCount() {
    return cache.stats().evictionCount();
  }
}
