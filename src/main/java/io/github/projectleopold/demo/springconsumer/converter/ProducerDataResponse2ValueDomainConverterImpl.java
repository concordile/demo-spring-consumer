package io.github.projectleopold.demo.springconsumer.converter;

import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import org.springframework.stereotype.Component;

@Component
public class ProducerDataResponse2ValueDomainConverterImpl implements ProducerDataResponse2ValueDomainConverter {

    @Override
    public ValueDomain convert(ProducerDataResponse data) {
        return ValueDomain.builder()
                .value(data.getValue())
                .build();
    }

}
