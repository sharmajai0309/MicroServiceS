package com.Jai.Cloud.Routing;

import java.util.UUID;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyRoutingConfig {
	
//	@Bean
	public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("CartDetails", r -> r
						.path("/v1/api/cart/**")
						.filters(F -> F.addRequestHeader("Token",UUID.randomUUID().toString()) // Pre FilterDate
								.addResponseHeader("ServerStatus", "Active")) //Post Filter data
						.uri("lb://CART-SERVICE")) // Use load balancing

				.route("OrderDetails", r -> r
					    .path("/v1/api/order/**")
					    .filters(f -> f.addRequestHeader("X-Request-Id", "12345")) // Example header
					    .uri("lb://SpringCloudOrderService"))
				// Use load balancing
				.build();
	}
}
