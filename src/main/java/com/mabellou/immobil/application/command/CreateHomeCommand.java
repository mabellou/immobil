package com.mabellou.immobil.application.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateHomeCommand {
    public final String url;

    @JsonCreator
    public CreateHomeCommand(@JsonProperty("url") String url) {
        this.url = url;
    }
}
