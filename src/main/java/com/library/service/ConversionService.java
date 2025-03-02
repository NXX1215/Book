package com.library.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class ConversionService implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Formatter<LocalDateTime> localDateTimeFormatter = new Formatter<LocalDateTime>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.parse(text, formatter);
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return object.format(formatter);
            }
        };
        registry.addFormatter(localDateTimeFormatter);
    }
}
