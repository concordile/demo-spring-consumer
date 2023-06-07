package io.github.projectleopold.demo.springconsumer.service;

import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        properties = "producer-service.url=http://localhost:18081")
@AutoConfigureStubRunner(ids = "io.github.projectleopold.demo:spring-producer:+:stubs:18081")
class ProducerValueServiceContractTest {

    @Test
    void should_return_newValue(@Autowired ValueService valueService) {
        ValueDomain newValue = valueService.createNewValue();
        Assertions.assertThat(newValue.getValue()).startsWith("value-");
    }

}