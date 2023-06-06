package io.github.projectleopold.demo.springconsumer.converter;

import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ProducerDataResponse2ValueDomainConverterImpl.class)
class ProducerDataResponse2ValueDomainConverterImplTest {

    @Test
    void should_convert(@Autowired ProducerDataResponse2ValueDomainConverter converter) {
        ValueDomain domain = converter.convert(ProducerDataResponse.builder()
                .id("id")
                .value("value")
                .build());
        assertEquals(ValueDomain.builder()
                .value("value")
                .build(), domain);
    }

}