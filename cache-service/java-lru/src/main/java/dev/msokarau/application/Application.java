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
import dev.msokarau.services.Scanner.ScannerService;

public class Application {
    public static void main(String[] args) {
        CacheService cacheService = new CacheService();
        ScannerService scannerService = new ScannerService(cacheService);

        scannerService.run();
    }
}
