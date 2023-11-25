package dev.msokarau.services.Cache;

import static org.junit.Assert.*;

import org.junit.Test;

public class CacheEntryTest {

  @Test
  public void testGetValue() {
    CacheEntry entry = new CacheEntry("test");
    assertEquals("test", entry.getValue());
  }

  @Test
  public void testGetLastAccessTime() {
    CacheEntry entry = new CacheEntry("test");
    long before = System.currentTimeMillis();
    entry.getValue(); // update lastAccessTime
    long after = System.currentTimeMillis();
    assertTrue(entry.getLastAccessTime() >= before && entry.getLastAccessTime() <= after);
  }
}