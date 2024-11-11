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

package io.github.concordile.demo.springconsumer.scheduler;

import io.github.concordile.demo.springconsumer.domain.ValueDomain;
import io.github.concordile.demo.springconsumer.service.ValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValueScheduler {

    private final ValueService valueService;

    @Scheduled(fixedDelay = 5000L)
    public void scheduleCreatingNewValue() {
        ValueDomain newValue = valueService.createNewValue();
        log.info("Created new value - {}", newValue);
    }

}