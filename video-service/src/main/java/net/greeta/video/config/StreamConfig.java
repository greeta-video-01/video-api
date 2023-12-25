package net.greeta.video.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class StreamConfig {
  @Value("${server.stream.prefix:http://localhost:9000/video/api/video/}")
  private String prefix;
}
