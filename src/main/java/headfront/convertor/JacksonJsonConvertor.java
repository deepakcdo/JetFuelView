package headfront.convertor;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Deepak on 30/03/2016.
 */
public class JacksonJsonConvertor implements MessageConvertor {

    private ObjectMapper jsonObjectMapper = new ObjectMapper();

    @Override
    public String convertToString(Map data) {
        try {
            return jsonObjectMapper.writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create Json for " + data, e);
        }
    }

    @Override
    public Map<String, Object> convertToMap(String data) {
        try {
            return jsonObjectMapper.readValue(data, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Unable to decode to Json data " + data, e);
        }
    }
}
