package dev.msokarau.application;

// Implement cache service. Cache entries (objects) – simple custom class with one String field. Your cache service should have 2 methods: get and put.
// Your cache service should fit next requirements:
// Max Size = 100 000
// Eviction policy
// Time-based on last access (5 seconds)
// Removal listener
// Just add to log of removed entry
// Give statistic to user
// Average time spent for putting new values into cache
// Number of cache evictions
// Support concurrency

import dev.msokarau.services.Cache.CacheService;

public class Application {
    public static void main(String[] args) {
        CacheService cacheService = new CacheService();

        // Put 100100 entries into cache, 100 more than the maximum allowed
        // 100 entries will be evicted immediately because of the maximum size limit
        for (int i = 0; i < 120; i++) { // can be set to 100000, but console output is too huge ^^
            cacheService.put(String.valueOf(i), "Value " + i);
        }

        cacheService.sleep(2000);

        System.out.println("Value for key '102': " + cacheService.get("102"));

        // Wait for a while to see eviction in action
        cacheService.sleep(4000);

        // Entries less than 100 should be evicted because they are stale
        System.out.println("Value for key '99': " + cacheService.get("99"));
        // Entry 101 shoud be evicted because it was not accessed for 5 seconds
        System.out.println("Value for key '101': " + cacheService.get("101"));
        // Entry 102 should be still in cache
        System.out.println("Value for key '102': " + cacheService.get("102"));

        // Print statistics
        System.out.println(
                "\nAverage time spent for putting new values into cache: " + cacheService.getAveragePutTime()
                        + " nanoseconds");
        System.out.println("\nNumber of cache evictions: " + cacheService.getEvictionCount());

        // Shutdown the eviction scheduler
        cacheService.shutdown();
    }
}
