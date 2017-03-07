package push.utils;

import java.io.IOException;
import java.io.StringReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ObjectMapperUtil {

  private static ObjectMapper mapper = new ObjectMapper();
  
  public static String toJSON(Object object) throws JsonProcessingException {
      return mapper.writer().writeValueAsString(object);
  }

  public static <T> T toObject(String entity, Class<T> type) throws IOException {
    StringReader stringReader = new StringReader(entity);
    return mapper.readValue(stringReader, type);
  }

}
