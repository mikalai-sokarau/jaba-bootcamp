package dev.msokarau.classes.CacheEntryImpl;

import dev.msokarau.interfaces.CacheEntry.CacheEntry;

public class CacheEntryImpl implements CacheEntry {
  private String value;
  private long lastAccessTime;

  public CacheEntryImpl(String value) {
    this.value = value;
    this.lastAccessTime = System.currentTimeMillis();
  }

  public String getValue() {
    lastAccessTime = System.currentTimeMillis();
    return value;
  }

  public long getLastAccessTime() {
    return lastAccessTime;
  }
}
