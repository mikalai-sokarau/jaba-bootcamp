package dev.msokarau.ConfigImplTest;

import static org.junit.Assert.*;
import org.junit.Test;

import dev.msokarau.ConfigImpl.ConfigImpl;
import dev.msokarau.interfaces.Config.Config;

public class ConfigImplTest {

  @Test
  public void testDefaultConfig() {
    Config config = new ConfigImpl();
    assertEquals(config.getMaxItems(), 100000);
    assertEquals(config.getEvictionTime(), 5000);
    assertEquals(config.getEvictionPeriod(), 1000);
  }

  @Test
  public void testCustomConfig() {
    Config config = new ConfigImpl(10, 5, 15);
    assertEquals(config.getMaxItems(), 10);
    assertEquals(config.getEvictionTime(), 5);
    assertEquals(config.getEvictionPeriod(), 15);
  }

  @Test
  public void testCustomConfigWithMaxItems() {
    Config config = new ConfigImpl(10);
    assertEquals(config.getMaxItems(), 10);
    assertEquals(config.getEvictionTime(), 5000);
    assertEquals(config.getEvictionPeriod(), 1000);
  }

  @Test
  public void testCustomConfigWithMaxItemsAndEvictionTime() {
    Config config = new ConfigImpl(10, 5);
    assertEquals(config.getMaxItems(), 10);
    assertEquals(config.getEvictionTime(), 5);
    assertEquals(config.getEvictionPeriod(), 1000);
  }
}
