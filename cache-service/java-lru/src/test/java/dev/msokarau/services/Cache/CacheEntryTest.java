package dev.msokarau.services.Cache;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.msokarau.classes.CacheEntryImpl.CacheEntryImpl;

public class CacheEntryTest {

  @Test
  public void testGetValue() {
    CacheEntryImpl entry = new CacheEntryImpl("test");
    assertEquals("test", entry.getValue());
  }

  @Test
  public void testGetLastAccessTime() {
    CacheEntryImpl entry = new CacheEntryImpl("test");
    long before = System.currentTimeMillis();
    entry.getValue(); // update lastAccessTime
    long after = System.currentTimeMillis();
    assertTrue(entry.getLastAccessTime() >= before && entry.getLastAccessTime() <= after);
  }
}