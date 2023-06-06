package io.github.projectleopold.demo.springconsumer.service;

import io.github.projectleopold.demo.springconsumer.client.ProducerClient;
import io.github.projectleopold.demo.springconsumer.converter.ProducerDataResponse2ValueDomainConverter;
import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataRequest;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ProducerValueService implements ValueService {

    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-hh:mm:ss");

    private final ProducerClient producerClient;
    private final ProducerDataResponse2ValueDomainConverter valueDomainConverter;

    @Override
    public ValueDomain createNewValue() {
        String dt = dtFormatter.format(LocalDateTime.now());
        ProducerDataRequest request = ProducerDataRequest.builder()
                .id("id-" + dt)
                .value(dt)
                .build();
        ProducerDataResponse response = producerClient.create(request);
        return valueDomainConverter.convert(response);
    }

}
