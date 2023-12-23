package net.greeta.video.repository.video;

import net.greeta.video.models.video.Video;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, UUID> {
  Optional<Video> findById(UUID id);
}
