package com.halloween.spring_gateway_example.config.filter;

import com.halloween.spring_gateway_example.config.OpenApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class RouteValidator {

    @Autowired
    private OpenApiProperties openApiProperties;

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiProperties.getEndpoints()
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}