package net.greeta.video.data.storage;

import net.greeta.video.validation.VideoFileName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DownloadRequest {
  @VideoFileName String fileName;
}
