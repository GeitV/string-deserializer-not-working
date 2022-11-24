package com.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;
import org.jetbrains.annotations.Nullable;

@Serdeable
@ReflectiveAccess
public class Ping {
    private final String name;
    private final int otherField;

    @JsonCreator
    public Ping(@Nullable String name, int otherField) {
        this.name = name;
        this.otherField = otherField;
    }

    public String getName() {
        return name;
    }

    public int getOtherField() {
        return otherField;
    }
}
