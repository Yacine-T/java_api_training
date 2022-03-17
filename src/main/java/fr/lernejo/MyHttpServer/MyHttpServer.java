package fr.lernejo.MyHttpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyHttpServer {

    public void init() throws IOException {
        int port = 9876;
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 9876), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new MyHttpHandler());
        server.start();
    }

}
