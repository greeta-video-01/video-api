package net.greeta.video.data.video;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.greeta.video.models.video.EventResult;

import java.io.IOException;

public class EventResultDtoDeserializer extends StdDeserializer {
  private static final ObjectMapper mapper = new ObjectMapper();

  public EventResultDtoDeserializer() {
    super(EventResultDtoDeserializer.class);
  }

  protected EventResultDtoDeserializer(Class vc) {
    super(vc);
  }

  @Override
  public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JacksonException {
    EventResultDto eventResultDto = new EventResultDto();
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    eventResultDto.setResult(mapper.treeToValue(node.get("after"), EventResult.class));
    return eventResultDto;
  }
}
