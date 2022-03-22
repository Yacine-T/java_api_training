package fr.lernejo.MyHttpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyHttpServer {

    public void init() throws IOException {
        int port = 5001;
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new PingHttpHandler());
        server.createContext("/api/game/start", new StartHttpHandler());
        server.start();
        System.out.println("Server started at port :" + port);
    }

}
