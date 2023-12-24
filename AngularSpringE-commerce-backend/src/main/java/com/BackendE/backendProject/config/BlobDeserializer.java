package com.BackendE.backendProject.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
 
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobDeserializer extends StdDeserializer<Blob> {

    public BlobDeserializer() {
        this(null);
    }

    public BlobDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Blob deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        byte[] data = node.binaryValue();

        try {
            return new javax.sql.rowset.serial.SerialBlob(data);
        } catch (SQLException e) {
            throw new IOException("Error creating Blob", e);
        }
    }
}
