package io.github.projectleopold.demo.springconsumer.converter;

import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import org.springframework.core.convert.converter.Converter;

public interface ProducerDataResponse2ValueDomainConverter
        extends Converter<ProducerDataResponse, ValueDomain> {

    @Override
    ValueDomain convert(ProducerDataResponse data);

}
