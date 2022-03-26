package fr.lernejo.server;

import fr.lernejo.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class StartHttpHandlerTest {

    Runtime rt = Runtime.getRuntime();

    @Test
    public void testStartHttphHandler_WhenHttpMethodIsValidAndBody_ShouldReturnCodeStatus202() throws IOException, InterruptedException {
        Server server = new Server(9875, "localhost");
        server.init();
        Client client = new Client(9875);
        HttpResponse resp =  client.sendPostRequest(8764, "http://localhost:9875/api/game/start");
        Assertions.assertEquals(202, resp.statusCode());
    }

    @Test
    public void testStartHttphHandler_WhenHttpMethodIsValidButBodyIsntValid_ShouldReturnCodeStatus400() throws IOException, InterruptedException {
        Server server = new Server(5000, "localhost");
        server.init();
        Client client = new Client(5000);
        HttpResponse resp =  client.sendWrongPostRequest(8763, "http://localhost:5000/api/game/start");
        Assertions.assertEquals(400, resp.statusCode());
    }

    @Test
    public void testStartHttphHandler_WhenHttpMethodIsntValid_ShouldReturnCodeStatus404() throws IOException, InterruptedException {
        Server server = new Server(5001, "localhost");
        server.init();
        Client client = new Client(5001);
        HttpResponse resp =  client.sendGetRequest(8762, "http://localhost:5001/api/game/start");
        Assertions.assertEquals(404, resp.statusCode());
    }



}
