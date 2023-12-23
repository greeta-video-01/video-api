package net.greeta.video.data.video;

import net.greeta.video.validation.UUID;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TsRequest {
  @Parameter(in = ParameterIn.PATH)
  @UUID(message = "invalid video id !")
  String id;

  @Parameter(in = ParameterIn.PATH)
  @NotBlank
  String ts;
}
