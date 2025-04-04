package com.i2i.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;
import java.util.List;

@Document(collection = "vital_sign_audit_logs")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VitalSignAuditLog {

    @Id
    private String id;

    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant lastModified;

    private String modifyBy;

    private String action;

    private String entity;

    private long entityId;

    private List<Attribute> attributes;


    @SuperBuilder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Attribute {
        private String name;

        private String oldValue;

        private String newValue;
    }
}
