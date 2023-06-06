package io.github.projectleopold.demo.springconsumer.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.github.projectleopold.demo.springconsumer.client")
public class ClientConfiguration {
}
