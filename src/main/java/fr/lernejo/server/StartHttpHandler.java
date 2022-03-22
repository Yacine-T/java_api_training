package fr.lernejo.server;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class StartHttpHandler implements HttpHandler {

    public final ObjectMapper obj = new ObjectMapper();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equals("POST"))
        {
            isValidBodyPostRequest(exchange);
            exchange.close();
        }
        else {
            exchange.sendResponseHeaders(404, "NOT FOUND".length());
            exchange.getResponseBody().write("NOT FOUND".getBytes());
            exchange.close();
        }
    }


    public List<String> loadJson(HttpExchange exchange) throws IOException {
        JsonNode json;
        if(!Objects.isNull(exchange))
            json = this.obj.readTree(exchange.getRequestBody());
        else
            json = this.obj.readTree(new File("src/ressources/json/startGame.json"));
        Iterator<String> it = json.fieldNames();
        List<String> keys = new ArrayList<String>();
        it.forEachRemaining(e -> keys.add(e));
        return keys;
    }


    public void isValidBodyPostRequest(HttpExchange exchange) throws IOException {
        List<String> keysFromFile = loadJson(null);
        List<String> keysFromHttpBody = loadJson(exchange);
        if (keysFromFile.equals(keysFromHttpBody)) {
            exchange.sendResponseHeaders(202, "ACCEPTED".length());
            exchange.getResponseBody().write("ACCEPTED".getBytes());
        }
        else {
            exchange.sendResponseHeaders(400, "BAD REQUEST".length());
            exchange.getResponseBody().write("BAD REQUEST".getBytes());
        }
    }
}
