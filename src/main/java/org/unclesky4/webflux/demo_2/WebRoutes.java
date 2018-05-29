package org.unclesky4.webflux.demo_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 
 * @ClassName: WebRoutes 
 * @Description: 创建Route
 * @author: unclesky4
 * @date: May 28, 2018 9:40:14 PM
 */

@Configuration
public class WebRoutes {
	
	TestHandler handler = new TestHandler();
	
	@Bean
	public RouterFunction<ServerResponse> route() {
		return RouterFunctions.route(RequestPredicates.GET("/getName"), 
				request -> ServerResponse.ok().body(BodyInserters.fromObject("aaa")))
				.andRoute(RequestPredicates.GET("/info"), handler::info);
	}
}
