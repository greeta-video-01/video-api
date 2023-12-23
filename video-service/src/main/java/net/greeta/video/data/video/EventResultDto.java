package net.greeta.video.data.video;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.greeta.video.models.video.EventResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonDeserialize(using = EventResultDtoDeserializer.class)
public class EventResultDto {
  EventResult result;
}
