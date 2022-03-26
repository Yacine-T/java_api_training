package fr.lernejo.server;

import fr.lernejo.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class PingHttpHandlerTest {

    @Test
    public void testPingRequestOnServer_whenRequestHasBeenAccepted_ShouldReturnCodeStatus200() throws IOException, InterruptedException {
        Server server = new Server(9876, "localhost");
        server.init();
        Client client = new Client(8795);
        HttpResponse resp =  client.sendRequest(8765, "http://localhost:9876/ping");
        Assertions.assertEquals(200, resp.statusCode());
    }

}
