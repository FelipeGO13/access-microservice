package br.com.mastertech.access.clients.customer;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

    @Bean
    public ErrorDecoder getCustumerClientDecoder(){
        return new CustomerClientDecoder();
    }

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CustomerClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }


}
