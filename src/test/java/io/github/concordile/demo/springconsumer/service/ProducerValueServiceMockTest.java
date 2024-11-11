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

import io.github.concordile.demo.springconsumer.client.ProducerClient;
import io.github.concordile.demo.springconsumer.domain.ValueDomain;
import io.github.concordile.demo.springconsumer.payload.ProducerDataRequest;
import io.github.concordile.demo.springconsumer.payload.ProducerDataResponse;
import io.github.concordile.demo.springconsumer.generator.IdGenerator;
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