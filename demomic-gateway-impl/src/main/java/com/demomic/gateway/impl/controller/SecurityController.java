package com.demomic.gateway.impl.controller;

import com.demomic.gateway.impl.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.webflux.ProxyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SecurityController {

    @GetMapping("/test")
    public Mono<User> proxy(ProxyExchange<byte[]> proxy) throws Exception {
        
        return Mono.just(new User("name", "firstName", "last name", List.of()));
    }
}
