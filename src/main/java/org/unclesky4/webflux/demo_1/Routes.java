package org.unclesky4.webflux.demo_1;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

public class Routes {
	
	MainHandler handler = new MainHandler();
	
	public RouterFunction<ServerResponse> rout() {
		return RouterFunctions.route(RequestPredicates.GET("/getName").and(RequestPredicates.accept(MediaType.ALL)), 
				request -> ServerResponse.ok().body(BodyInserters.fromObject(handler.getName())));
	}

}
