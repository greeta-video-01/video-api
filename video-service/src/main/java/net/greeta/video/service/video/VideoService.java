package net.greeta.video.service.video;

import net.greeta.video.data.video.VideoProfile;
import net.greeta.video.exception.DoesNotExist;
import net.greeta.video.models.video.EventResult;
import java.util.List;
import java.util.UUID;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface VideoService {
  public VideoProfile createFromObjectStorage(String userId, String title, String objectName) throws Exception;

  StreamingResponseBody m3u8Index(UUID videoId) throws DoesNotExist;

  StreamingResponseBody ts(UUID videoId, String ts) throws DoesNotExist;

  List<VideoProfile> list();

  VideoProfile profile(UUID videoId) throws DoesNotExist;

  void onVideoEventComplete(EventResult eventResult) throws Exception;
}
