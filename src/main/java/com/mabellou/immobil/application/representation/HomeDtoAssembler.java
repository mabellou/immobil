package com.mabellou.immobil.application.representation;

import com.mabellou.immobil.domain.model.Home;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HomeDtoAssembler implements Converter<Home, HomeDto> {

    @Override
    public HomeDto convert(Home source) {
        return new HomeDto(source.getUrl());
    }
}
