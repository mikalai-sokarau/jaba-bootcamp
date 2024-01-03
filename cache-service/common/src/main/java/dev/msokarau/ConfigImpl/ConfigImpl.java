package dev.msokarau.ConfigImpl;

import dev.msokarau.interfaces.Config.Config;

public class ConfigImpl implements Config {
  private static final int DEFAULT_MAX_ITEMS = 100000;
  private static final int EVICTION_TIME_THRESHOLD = 5000; // 5 seconds
  private static final int EVICTION_PERIOD = 1000; // 1 second
  private int maxItems;
  private int evictionTime;
  private int evictionPeriod;

  public ConfigImpl() {
    this(DEFAULT_MAX_ITEMS, EVICTION_TIME_THRESHOLD, EVICTION_PERIOD);
  }

  public ConfigImpl(int maxItems) {
    this(maxItems, EVICTION_TIME_THRESHOLD, EVICTION_PERIOD);
  }

  public ConfigImpl(int maxItems, int evictionTime) {
    this(maxItems, evictionTime, EVICTION_PERIOD);
  }

  public ConfigImpl(int maxItems, int evictionTime, int evictionPeriod) {
    this.maxItems = maxItems;
    this.evictionTime = evictionTime;
    this.evictionPeriod = evictionPeriod;
  }

  public ConfigImpl(String[] args) {
    this();

    if (args.length > 0) {
      this.maxItems = Integer.parseInt(args[0]);
    }
    if (args.length > 1) {
      this.evictionTime = Integer.parseInt(args[1]);
    }
    if (args.length > 2) {
      this.evictionPeriod = Integer.parseInt(args[2]);
    }
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
