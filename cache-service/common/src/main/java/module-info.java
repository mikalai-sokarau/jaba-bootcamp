module common {
  requires transitive service.api;

  exports dev.msokarau.classes.CacheEntryImpl;
  exports dev.msokarau.classes.ConfigImpl;
  exports dev.msokarau.classes.ScannerServiceImpl;
}
