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

import dev.msokarau.interfaces.CacheService.CacheService;
import dev.msokarau.interfaces.ScannerService.ScannerService;
import dev.msokarau.CacheServiceImpl.CacheServiceImpl;
import dev.msokarau.ScannerServiceImpl.ScannerServiceImpl;

public class Application {
    public static void main(String[] args) {
        CacheService cacheService = new CacheServiceImpl();
        ScannerService scannerService = new ScannerServiceImpl(cacheService);

        scannerService.run();
    }
}
