package com.ahmetarabaci.apigateway.routelocator;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {
	
	/**
	 * API Gateway route definitions.
	 * 
	 * @author Ahmet Arabacı
	 * @since 03.02.2025 15:40
	 */
	@Bean
	public RouteLocator getRouteLocatorConf(RouteLocatorBuilder builder) {
		return builder.routes()
			// API Gateway with proxy URL.
			.route("multiplication-service-proxyurl", r -> r
				.path("/execmultiplication/**")
				.filters(f -> f.rewritePath("/execmultiplication/(?<segment>.*)", "/multiply/${segment}"))
				.uri("lb://multiplication-service"))

			// API Gateway with base URL.
			.route("multiplication-service-baseurl", r -> r
				.path("/multiply/**")					
				.uri("lb://multiplication-service"))
			.build();
	}
	
}

