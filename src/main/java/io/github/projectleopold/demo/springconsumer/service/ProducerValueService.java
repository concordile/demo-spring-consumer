package io.github.projectleopold.demo.springconsumer.service;

import io.github.projectleopold.demo.springconsumer.client.ProducerClient;
import io.github.projectleopold.demo.springconsumer.converter.ProducerDataResponse2ValueDomainConverter;
import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataRequest;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import io.github.projectleopold.demo.springconsumer.generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerValueService implements ValueService {


    private final IdGenerator idGenerator;
    private final ProducerClient producerClient;
    private final ProducerDataResponse2ValueDomainConverter valueDomainConverter;

    @Override
    public ValueDomain createNewValue() {
        String id = idGenerator.generateId();
        ProducerDataRequest request = ProducerDataRequest.builder()
                .id("id-" + id)
                .value("value-" + id)
                .build();
        ProducerDataResponse response = producerClient.create(request);
        return valueDomainConverter.convert(response);
    }

}
