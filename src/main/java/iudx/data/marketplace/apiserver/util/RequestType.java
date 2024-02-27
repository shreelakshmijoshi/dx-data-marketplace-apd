package iudx.data.marketplace.apiserver.util;

public enum RequestType {
  PRODUCT("product"),
  PRODUCT_VARIANT("product_variant"),
  RESOURCE("resource"),
  POLICY("policy"),
  VERIFY("verify_policy"),
  PROVIDER("provider"),
  ORDER("order"),
  PURCHASE("purchase"),
  VERIFY_PAYMENT("verify_payment"),
  PURCHASE("purchase"),
  POST_ACCOUNT("post_account"),
  PUT_ACCOUNT("put_account");

  private String filename;

  public String getFilename() {
    return this.filename;
  }

  private RequestType(String filename) {
    this.filename = filename;
  }
}
