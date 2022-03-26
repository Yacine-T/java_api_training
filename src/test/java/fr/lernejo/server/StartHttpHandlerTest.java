package fr.lernejo.server;

import fr.lernejo.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class StartHttpHandlerTest {


    @Test
    public void testStartHttphHandler_WhenHttpMethodIsValidAndBody_ShouldReturnCodeStatus202() throws IOException, InterruptedException {
        Server server = new Server(9876, "localhost");
        server.init();
        Client client = new Client(8795);
        HttpResponse resp =  client.sendPostRequest(8765, "http://localhost:9876/api/game/start");
        Assertions.assertEquals(202, resp.statusCode());
    }

    @Test
    public void testStartHttphHandler_WhenHttpMethodIsValidButBodyIsntValid_ShouldReturnCodeStatus400() throws IOException, InterruptedException {
        Server server = new Server(9876, "localhost");
        server.init();

        Client client = new Client(8795);
        HttpResponse resp =  client.sendWrongPostRequest(8765, "http://localhost:9876/api/game/start");
        Assertions.assertEquals(400, resp.statusCode());
    }

    @Test
    public void testStartHttphHandler_WhenHttpMethodIsntValid_ShouldReturnCodeStatus404() throws IOException, InterruptedException {
        Server server = new Server(9876, "localhost");
        server.init();
        Client client = new Client(8795);
        HttpResponse resp =  client.sendGetRequest(8765, "http://localhost:9876/api/game/start");
        Assertions.assertEquals(404, resp.statusCode());
    }



}
