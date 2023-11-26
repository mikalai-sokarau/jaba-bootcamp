package dev.msokarau;

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
