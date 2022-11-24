package com.example.model;

import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;
import org.jetbrains.annotations.Nullable;

@Serdeable
@ReflectiveAccess
public record Ping(@Nullable String name, int otherField) {
}
