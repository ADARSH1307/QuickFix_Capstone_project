package com.ust.OrdersServiceProvider.feign;


import com.ust.OrdersServiceProvider.dto.ServiceProviderDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class ServiceProviderClient {
    private final WebClient webClient;

    public ServiceProviderClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8888").build();

    }

    public Mono<ServiceProviderDTO> getServiceProviderById(String sid) {
        return webClient.get()
                .uri("/provider/{sid}", sid)
                .retrieve()
                .bodyToMono(ServiceProviderDTO.class);
    }




}