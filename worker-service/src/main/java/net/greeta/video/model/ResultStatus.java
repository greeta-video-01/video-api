package net.greeta.video.model;

public enum ResultStatus {
  SUCCESS("SUCCESS"),
  FAIL("FAIL");

  private final String value;

  ResultStatus(String role) {
    this.value = role;
  }

  public String toString() {
    return value;
  }
}
