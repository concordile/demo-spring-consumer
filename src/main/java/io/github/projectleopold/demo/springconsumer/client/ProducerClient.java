package io.github.projectleopold.demo.springconsumer.client;

import io.github.projectleopold.demo.springconsumer.dto.ProducerDataRequest;
import io.github.projectleopold.demo.springconsumer.dto.ProducerDataResponse;
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
