package Usuarios.Serializers;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

        @Override
        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.toString()); // serializa LocalDate a String en formato ISO-8601
        }

        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return LocalDate.parse(json.getAsString()); // deserializa el String al objeto LocalDate
        }
}
