package io.github.projectleopold.demo.springconsumer.service;

import io.github.projectleopold.demo.springconsumer.client.ProducerClient;
import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataRequest;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import io.github.projectleopold.demo.springconsumer.generator.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProducerValueServiceMockTest {

    @MockBean
    IdGenerator idGenerator;

    @MockBean
    ProducerClient producerClient;

    @Test
    void should_return_newValue(@Autowired ValueService valueService) {
        when(idGenerator.generateId()).thenReturn("foobar");
        when(producerClient.create(eq(ProducerDataRequest.builder()
                .id("id-foobar")
                .value("value-foobar")
                .build())))
                .thenReturn(ProducerDataResponse.builder()
                        .id("id-foobar")
                        .value("value-foobar")
                        .build());
        ValueDomain newValue = valueService.createNewValue();
        assertEquals(ValueDomain.builder()
                .value("value-foobar")
                .build(), newValue);
    }

}