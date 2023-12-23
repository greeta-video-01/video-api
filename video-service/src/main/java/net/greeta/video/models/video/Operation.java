package net.greeta.video.models.video;

public enum Operation {
  PROCESS("PROCESS"),
  DELETE("DELETE");

  private final String value;

  Operation(String role) {
    this.value = role;
  }

  public String toString() {
    return value;
  }
}
