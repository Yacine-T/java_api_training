package fr.lernejo.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    final  HttpClient client = HttpClient.newHttpClient();
    final int port;
    public Client(int port)
    {

        this.port = port;
    }

    public HttpResponse sendPostRequest(int myPort, String adversaryUrl) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + myPort + "\", \"message\":\"hello\"}"))
            .build();

            HttpResponse response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
    }

    public HttpResponse sendWrongPostRequest(int myPort, String adversaryUrl) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"url\":\"http://localhost:" + myPort + "\", \"message\":\"hello\"}"))
            .build();

        HttpResponse response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public HttpResponse sendGetRequest(int myPort, String adversaryUrl) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .GET().build();

        HttpResponse response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
