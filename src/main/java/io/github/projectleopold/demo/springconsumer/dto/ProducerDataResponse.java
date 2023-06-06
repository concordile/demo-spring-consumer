package io.github.projectleopold.demo.springconsumer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProducerDataResponse {

    private String id;
    private String value;

}
