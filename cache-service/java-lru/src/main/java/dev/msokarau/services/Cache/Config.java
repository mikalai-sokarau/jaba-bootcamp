package dev.msokarau.services.Cache;

public class Config {
  private static final int DEFAULT_MAX_ITEMS = 100000;
  private static final int EVICTION_TIME_THRESHOLD = 5000; // 5 seconds
  private static final int EVICTION_PERIOD = 1000; // 1 second
  private int maxItems;
  private int evictionTime;
  private int evictionPeriod;

  public Config() {
    this(DEFAULT_MAX_ITEMS, EVICTION_TIME_THRESHOLD, EVICTION_PERIOD);
  }

  public Config(int maxItems) {
    this(maxItems, EVICTION_TIME_THRESHOLD, EVICTION_PERIOD);
  }

  public Config(int maxItems, int evictionTime) {
    this(maxItems, evictionTime, EVICTION_PERIOD);
  }

  public Config(int maxItems, int evictionTime, int evictionPeriod) {
    this.maxItems = maxItems;
    this.evictionTime = evictionTime;
    this.evictionPeriod = evictionPeriod;
  }

  public int getMaxItems() {
    return maxItems;
  }

  public int getEvictionTime() {
    return evictionTime;
  }

  public int getEvictionPeriod() {
    return evictionPeriod;
  }
}
