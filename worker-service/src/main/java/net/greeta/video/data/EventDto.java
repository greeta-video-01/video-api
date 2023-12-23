package net.greeta.video.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.greeta.video.model.VideoEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonDeserialize(using = EventDtoDeserializer.class)
public class EventDto {
  VideoEvent event;
}
