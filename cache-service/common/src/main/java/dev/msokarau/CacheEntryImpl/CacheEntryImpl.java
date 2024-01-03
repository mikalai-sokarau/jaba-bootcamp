package dev.msokarau.CacheEntryImpl;

import dev.msokarau.interfaces.CacheEntry.CacheEntry;

public class CacheEntryImpl implements CacheEntry {
  private String value;
  private int frequency;
  private long lastAccessTime;

  public CacheEntryImpl(String value) {
    this.value = value;
    this.frequency = 0;
    this.lastAccessTime = System.currentTimeMillis();
  }

  public String getValue() {
    frequency++;
    lastAccessTime = System.currentTimeMillis();

    return value;
  }

  public long getLastAccessTime() {
    return lastAccessTime;
  }

  public int getFrequency() {
    return frequency;
  }
}
