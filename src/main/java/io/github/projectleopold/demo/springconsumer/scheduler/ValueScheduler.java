package io.github.projectleopold.demo.springconsumer.scheduler;

import io.github.projectleopold.demo.springconsumer.domain.ValueDomain;
import io.github.projectleopold.demo.springconsumer.service.ValueService;
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
