package net.greeta.video.helper;

import net.greeta.video.security.JwtAuthConverterProperties;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;

public class JwtHelper {

  public static String getUsername(Jwt jwt, JwtAuthConverterProperties properties) {
    String claimName = JwtClaimNames.SUB;
    if (properties.getPrincipalAttribute() != null) {
      claimName = properties.getPrincipalAttribute();
    }
    return jwt.getClaim(claimName);
  }

}

