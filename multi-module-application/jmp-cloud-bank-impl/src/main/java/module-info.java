module cloud.bank.impl {
  requires dto;
  requires transitive bank.api;

  provides dev.msokarau.bank.api.Bank with dev.msokarau.cloud.bank.impl.BankImpl;

  exports dev.msokarau.cloud.bank.impl;
}
