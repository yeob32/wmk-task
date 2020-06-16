package com.example.demo.converter;

import com.example.demo.domain.enums.Scope;
import org.springframework.core.convert.converter.Converter;

public class StringToScopeConverter implements Converter<String, Scope> {
    @Override
    public Scope convert(String source) {
        return Scope.valueOf(source.toUpperCase());
    }
}
