package io.github.projectleopold.demo.springconsumer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProducerDataRequest {

    private String id;
    private String value;

}
