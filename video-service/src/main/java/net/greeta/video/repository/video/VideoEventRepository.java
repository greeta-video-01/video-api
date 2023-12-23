package net.greeta.video.repository.video;

import net.greeta.video.models.video.VideoEvent;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoEventRepository extends JpaRepository<VideoEvent, UUID> {
  Optional<VideoEvent> findById(UUID id);
}
