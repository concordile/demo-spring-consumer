/*
 * Copyright 2023-2024 The Concordile Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.concordile.demo.springconsumer.service;

import io.github.concordile.demo.springconsumer.domain.ValueDomain;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        properties = "producer-service.url=http://localhost:18081")
@AutoConfigureStubRunner(
        ids = "io.github.concordile.demo:spring-producer:+:stubs:18081",
        stubsPerConsumer = true)
class ProducerValueServiceContractTest {

    @Test
    void should_return_newValue(@Autowired ValueService valueService) {
        ValueDomain newValue = valueService.createNewValue();
        Assertions.assertThat(newValue.getValue()).startsWith("value-");
    }

}