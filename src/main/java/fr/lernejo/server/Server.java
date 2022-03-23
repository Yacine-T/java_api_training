package fr.lernejo.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {

    public final int port;
    public final String url;
    public Server(int port, String url)
    {
        this.port = port;
        this.url = url;
    }

    public void init() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(this.url, this.port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new PingHttpHandler());
        server.createContext("/api/game/start", new StartHttpHandler());
        server.start();
        System.out.println("Server started at port : " + this.port);
    }

}
