module application {
  requires dto;
  requires cloud.bank.impl;
  requires cloud.service.impl;

  exports dev.msokarau.application;
}
