module cloud.service.impl {
  requires dto;
  requires transitive service.api;
  requires com.google.auto.service;

  provides dev.msokarau.service.api.Service with dev.msokarau.cloud.service.impl.ServiceImpl;

  exports dev.msokarau.cloud.service.impl;
}
