package net.greeta.video.service.user.auth;

import net.greeta.video.data.UserDetail;
import net.greeta.video.models.User;
import net.greeta.video.repository.user.UserRepository;
import net.greeta.video.service.storage.ObjectStorageService;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailService implements UserDetailsService {
  @Autowired UserRepository userRepository;
  @Autowired
  ObjectStorageService storageService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =
        userRepository
            .getByUserName(username)
            .orElseThrow(() -> new UsernameNotFoundException("user does not exist !"));
    return new UserDetail(user);
  }

  @Transactional
  public void createUserIfAbsent(String userName) throws Exception {
    if (!userRepository.existsByUserName(userName)) {
      User user = new User(UUID.randomUUID(), userName);
      userRepository.save(user);
      storageService.createFolder("user/" + user.getUserName() + "/");
    }
  }
}
