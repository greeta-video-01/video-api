package net.greeta.video.service.jwt;

import net.greeta.video.data.UserDetail;
import net.greeta.video.exception.InvalidTokenException;
import net.greeta.video.service.redis.RedisService;
import net.greeta.video.helper.JwtHelper;
import net.greeta.video.security.JwtAuthConverterProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
  @Autowired
  RedisService redisService;
  @Autowired JwtAuthConverterProperties jwtAuthConverterProperties;

  private static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

  @Override
  public UserDetail getUserDetailFromAccessToken(String token) throws InvalidTokenException {
    return new UserDetail(null, JwtHelper.getUsername(Jwt.withTokenValue(token).build(), jwtAuthConverterProperties));
  }

  @Override
  public boolean isAccessTokenInBlackList(String accessPlainToken) {
    return redisService.has("revoked_access_token:{" + accessPlainToken + "}");
  }
}
