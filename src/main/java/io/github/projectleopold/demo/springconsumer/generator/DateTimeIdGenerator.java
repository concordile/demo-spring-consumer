package io.github.projectleopold.demo.springconsumer.generator;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeIdGenerator implements IdGenerator {

    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-hh:mm:ss");

    @Override
    public String generateId() {
        return dtFormatter.format(LocalDateTime.now());
    }

}
