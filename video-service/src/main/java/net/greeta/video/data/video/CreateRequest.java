package net.greeta.video.data.video;

import net.greeta.video.validation.VideoFileName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRequest {
  @VideoFileName String fileName;

  @NotBlank
  @Size(min = 1, max = 128)
  String title;
}
