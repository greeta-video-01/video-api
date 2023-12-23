package net.greeta.video.autoconfiguration;

import net.greeta.video.config.GlobalConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GlobalConfiguration.class)
public class EshopRestAutoconfiguration {
}
