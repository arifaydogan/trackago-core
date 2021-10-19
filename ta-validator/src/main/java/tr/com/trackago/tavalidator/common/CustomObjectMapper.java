package tr.com.trackago.tavalidator.common;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = -987364856739313L;

    public CustomObjectMapper() {
        super.setSerializationInclusion(Include.ALWAYS);
        super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        super.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public <T> T cloneObject(T model, Class<T> targetType) {
        return this.convertObject(model, targetType);
    }

    public <T> T convertObject(Object source, Class<T> targetType) {
        try {
            final byte[] bytes = this.writeValueAsBytes(source);
            final T copy = this.readValue(bytes, targetType);
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T fromJson(String jsonString, Class<T> target) {
        try {
            return this.readValue(jsonString, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T fromJson(JsonNode node, Class<T> target) {
        try {
            return this.treeToValue(node, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toJson(Object input) {
        try {
            return this.writeValueAsString(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

