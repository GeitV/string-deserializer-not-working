package com.example.config;

import io.micronaut.context.annotation.Factory;
import io.micronaut.core.annotation.Order;
import io.micronaut.core.type.Argument;
import io.micronaut.serde.Decoder;
import io.micronaut.serde.Deserializer;
import jakarta.inject.Singleton;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@Factory
public class CustomDeserializer {

    @Singleton
    @Order(-100)
    Deserializer<String> stringDeserializer() {
        return new Deserializer<>() {
            @Override
            public String deserialize(@NotNull Decoder decoder, @NotNull DecoderContext context,
                                      @NotNull Argument<? super String> type) throws IOException {
                if (decoder.decodeNull()) return null;
                String str = decoder.decodeString();
                if (str.isBlank()) return null;
                return str;
            }

            @Override
            public boolean allowNull() {
                return true;
            }
        };
    }
}
