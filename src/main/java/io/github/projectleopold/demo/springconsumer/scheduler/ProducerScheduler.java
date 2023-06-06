package io.github.projectleopold.demo.springconsumer.scheduler;

import io.github.projectleopold.demo.springconsumer.client.ProducerClient;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataRequest;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProducerScheduler {

    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-hh:mm:ss");

    private final ProducerClient producerClient;

    @Scheduled(fixedDelay = 5000L)
    public void createProducerData() {
        String dt = dtFormatter.format(LocalDateTime.now());
        ProducerDataRequest request = ProducerDataRequest.builder()
                .id("id-" + dt)
                .value("value-" + dt)
                .build();
        ProducerDataResponse response = producerClient.create(request);
        log.info("Created Producer's data: " + response);
    }

}
