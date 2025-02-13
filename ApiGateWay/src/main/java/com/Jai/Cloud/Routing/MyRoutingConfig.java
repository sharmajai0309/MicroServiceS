package com.Jai.Cloud.Routing;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRoutingConfig {
	
	@Bean
	public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("CartDetails", r -> r
						.path("/v1/api/cart/**")  // Allow subpaths
						.uri("lb://CART-SERVICE")) // Use load balancing

				.route("OrderDetails", r -> r
						.path("/v1/api/order/**")  // Allow subpaths
						.uri("lb://SpringCloudOrderService")) // Use load balancing
				.build();
	}
}
