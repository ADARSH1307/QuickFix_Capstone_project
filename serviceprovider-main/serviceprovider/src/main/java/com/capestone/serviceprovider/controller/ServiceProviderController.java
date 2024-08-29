package com.capestone.serviceprovider.controller;

import com.capestone.serviceprovider.dto.ServiceProviderDTO;
import com.capestone.serviceprovider.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/provider")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ServiceProviderDTO> createServiceProvider(@RequestBody ServiceProviderDTO serviceProviderDTO) {
        return serviceProviderService.createServiceProvider(serviceProviderDTO);
    }

    @GetMapping("/{sid}")
    public Mono<ServiceProviderDTO> getServiceProviderById(@PathVariable String sid) {
        return serviceProviderService.getServiceProviderById(sid);
    }

    @PutMapping("/{sid}")
    public Mono<ServiceProviderDTO> updateServiceProvider(@PathVariable String sid, @RequestBody ServiceProviderDTO serviceProviderDTO) {
        return serviceProviderService.updateServiceProvider(sid, serviceProviderDTO);
    }

    @DeleteMapping("/{sid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteServiceProvider(@PathVariable String sid) {
        return serviceProviderService.deleteServiceProvider(sid);
    }

    @GetMapping
    public Flux<ServiceProviderDTO> getAllServiceProviders() {
        return serviceProviderService.getAllServiceProviders();
    }

    @GetMapping("/city/{city}")
    public Flux<ServiceProviderDTO> getServiceProvidersByCity(@PathVariable String city) {
        return serviceProviderService.getServiceProvidersByCity(city);
    }
}