package dev.msokarau.interfaces.CacheService;

public interface CacheService {
  public void put(String key, String value);

  public String get(String key);

  public long getAveragePutTime();

  public long getEvictionCount();

  public void shutdown();
}
