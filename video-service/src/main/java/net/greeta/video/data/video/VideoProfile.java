package net.greeta.video.data.video;

import net.greeta.video.models.video.Video;
import net.greeta.video.models.video.VideoStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoProfile {
  String id;
  String title;
  VideoStatus status;
  String owner;
  String creatAt;
  String eventResult;

  public VideoProfile(Video video) {
    this.id = video.getId().toString();
    this.title = video.getTitle();
    this.creatAt = video.getCreateAt().toString();
    this.status = video.getStatus();
    this.owner = video.getOwner().getId().toString();
    this.eventResult = video.getEventResult();
  }
}
