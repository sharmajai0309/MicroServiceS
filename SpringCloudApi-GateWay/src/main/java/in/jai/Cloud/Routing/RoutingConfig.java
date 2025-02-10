package in.jai.Cloud.Routing;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

	public RouteLocator Routesconfiguration(RouteLocatorBuilder Rbuilder) {
		Rbuilder
		.routes()
		.route("",r->r.path("").uri(""))
		.route("",r->r.path("").uri(""))
		.build();
		return null;
		
	}
	
	
}
