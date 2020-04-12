package me.ewan.springrestapi.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;

import java.io.IOException;

@JsonComponent
public class ErrorsSerializer extends JsonSerializer<Errors> {
    @Override
    public void serialize(Errors value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        value.getFieldErrors().stream().forEach(e -> {
            try {
                gen.writeStartObject();
                gen.writeStringField("Field", e.getField());
                gen.writeStringField("ObjectName", e.getObjectName());
                gen.writeStringField("Code", e.getCode());
                gen.writeStringField("DefaultMessage", e.getDefaultMessage());
                Object o = e.getRejectedValue();
                if(o != null){
                    gen.writeStringField("rejectedValue", o.toString());
                }
                gen.writeEndObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        value.getGlobalErrors().stream().forEach(e -> {
            try {
                gen.writeStartObject();
                gen.writeStringField("ObjectName", e.getObjectName());
                gen.writeStringField("Code", e.getCode());
                gen.writeStringField("DefaultMessage", e.getDefaultMessage());
                gen.writeEndObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        gen.writeEndArray();
    }
}
