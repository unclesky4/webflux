package org.unclesky4.webflux.demo_2;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class TestHandler{
	
	public Mono<ServerResponse> info(ServerRequest request) {
		String path = request.path();
		String param = request.queryParam("info").get().toString();
		return ServerResponse.ok().body(BodyInserters.fromObject(param));
	}

}
