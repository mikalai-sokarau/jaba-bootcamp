package dev.msokarau.interfaces.CacheEntry;

public interface CacheEntry {
  public String getValue();

  public long getLastAccessTime();

  public int getFrequency();
}
