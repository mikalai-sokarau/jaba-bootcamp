package dev.msokarau;

import dev.msokarau.CacheServiceImpl.CacheServiceImpl;
import dev.msokarau.ConfigImpl.ConfigImpl;
import dev.msokarau.ScannerServiceImpl.ScannerServiceImpl;
import dev.msokarau.interfaces.CacheService.CacheService;
import dev.msokarau.interfaces.ScannerService.ScannerService;

public class Application {
    public static void main(String[] args) {
        CacheService cacheService = new CacheServiceImpl(new ConfigImpl(args));
        ScannerService scannerService = new ScannerServiceImpl(cacheService);

        scannerService.run();
    }
}
