package in.jai.Cloud.Routing;

import org.springframework.cloud.gateway.route.RouteLocator; 
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

	public RouteLocator Routesconfiguration(RouteLocatorBuilder Rbuilder) {
		
		// This Java configuration based routing in API GateWay
		// Eureka Server will give the name of service that having minimum Load Factor
		
		
		RouteLocator routeLocator = Rbuilder
		.routes()
		.route("CartServices", r->r.path("/v1/api/cart/**").uri("CART-SERVICE"))
		.route("OrderService",r->r.path("/v1/api/order/**").uri("SpringCloudOrderService-FeignClient"))
		.build();
		
		return routeLocator;
		
	}
	
	
}
