package net.greeta.video.validation;

import net.greeta.video.exception.ValidationError;

public interface Validator<I, O> {
  public abstract O validate(I data) throws ValidationError;
}
