package net.greeta.video.exception;

public class ValidationError extends IllegalArgumentException {
  public ValidationError(String msg) {
    super(msg);
  }
}
