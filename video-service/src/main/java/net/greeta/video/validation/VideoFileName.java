package net.greeta.video.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Target(ElementType.FIELD)
@Constraint(validatedBy = {VideoFileNameValidator.class})
@NotBlank(message = "filename of the video cannot be empty !")
@Size(min = 1, max = 512)
@Retention(RUNTIME)
public @interface VideoFileName {
  String message() default "invalid filename of the video !";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
