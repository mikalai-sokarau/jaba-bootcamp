package dev.msokarau.services.Cache;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConfigTest {

  @Test
  public void testDefaultConfig() {
    Config config = new Config();
    assertEquals(config.getMaxItems(), 100000);
    assertEquals(config.getEvictionTime(), 5000);
    assertEquals(config.getEvictionPeriod(), 1000);
  }

  @Test
  public void testCustomConfig() {
    Config config = new Config(10, 5, 15);
    assertEquals(config.getMaxItems(), 10);
    assertEquals(config.getEvictionTime(), 5);
    assertEquals(config.getEvictionPeriod(), 15);
  }

  @Test
  public void testCustomConfigWithMaxItems() {
    Config config = new Config(10);
    assertEquals(config.getMaxItems(), 10);
    assertEquals(config.getEvictionTime(), 5000);
    assertEquals(config.getEvictionPeriod(), 1000);
  }

  @Test
  public void testCustomConfigWithMaxItemsAndEvictionTime() {
    Config config = new Config(10, 5);
    assertEquals(config.getMaxItems(), 10);
    assertEquals(config.getEvictionTime(), 5);
    assertEquals(config.getEvictionPeriod(), 1000);
  }
}
