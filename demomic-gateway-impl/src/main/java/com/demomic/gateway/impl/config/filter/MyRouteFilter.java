package com.demomic.gateway.impl.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class MyRouteFilter extends AbstractGatewayFilterFactory<MyRouteFilter.Config> {

    public MyRouteFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("Pre write GUZ log " + config.message);
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> log.info("Post write GUZ log" + config.message)));
        };
    }

    public static class Config {
        private String message;

        public Config() {

        }

        public Config(String message) {
            this.message = message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
