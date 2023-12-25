package net.greeta.video.repository.user;

import net.greeta.video.models.User;
import java.util.Optional;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

  boolean existsByUserName(String userName);

  Optional<User> getByUserName(String username);
}
