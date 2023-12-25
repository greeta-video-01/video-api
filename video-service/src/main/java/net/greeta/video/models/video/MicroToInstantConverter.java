package net.greeta.video.models.video;

import com.fasterxml.jackson.databind.util.StdConverter;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class MicroToInstantConverter extends StdConverter<String, Instant> {
  public Instant convert(final String value) {
    return Instant.parse(value);
  }
}
