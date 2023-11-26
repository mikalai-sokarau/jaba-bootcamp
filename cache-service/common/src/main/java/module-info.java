module common {
  requires transitive service.api;

  exports dev.msokarau.CacheEntryImpl;
  exports dev.msokarau.ConfigImpl;
  exports dev.msokarau.ScannerServiceImpl;
}
