package fr.lernejo.MyHttpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class PingHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, "OK".length());
        exchange.getResponseBody().write("OK".getBytes());
        exchange.close();
    }




}

