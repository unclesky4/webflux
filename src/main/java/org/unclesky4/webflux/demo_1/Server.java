package org.unclesky4.webflux.demo_1;

import java.io.IOException;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.ipc.netty.http.server.HttpServer;

/**
 * 
 * @ClassName: Server 
 * @Description: webFlux 简单实例  -- 失败
 * @author: unclesky4
 * @date: May 28, 2018 10:01:11 PM
 */
public class Server {
	
	public static final String HOST = "localhost";

    public static final int PORT = 8080;

    private Routes routes = new Routes();
    
    //Netty
    public void startReactorServer() throws InterruptedException {
        RouterFunction<ServerResponse> route = routes.rout();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);

        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create(HOST, PORT);
        server.newHandler(adapter).block();
    }

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = new Server();

		server.startReactorServer();

        System.out.println("Press ENTER to exit.");
        System.in.read();
	}

}
