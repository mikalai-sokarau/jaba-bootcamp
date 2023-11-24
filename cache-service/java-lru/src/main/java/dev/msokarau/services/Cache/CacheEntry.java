package dev.msokarau.services.Cache;

class CacheEntry {
  private String value;
  private long lastAccessTime;

  public CacheEntry(String value) {
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
