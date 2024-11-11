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

package io.github.concordile.demo.springconsumer.client;

import io.github.concordile.demo.springconsumer.payload.ProducerDataRequest;
import io.github.concordile.demo.springconsumer.payload.ProducerDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "producer-service", url = "${producer-service.url}", path = "/api/datum")
public interface ProducerClient {

    @PostMapping
    ProducerDataResponse create(@RequestBody ProducerDataRequest data);

    @GetMapping("/{dataId}")
    ProducerDataResponse get(@PathVariable String dataId);

    @GetMapping
    List<ProducerDataResponse> getAll();

    @DeleteMapping("/{dataId}")
    void delete(@PathVariable String dataId);

}
