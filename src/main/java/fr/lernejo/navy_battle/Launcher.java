package fr.lernejo.navy_battle;


import fr.lernejo.client.Client;
import fr.lernejo.server.Server;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(9876, "localhost");
        server.init();
        Client client = new Client(8765);
        HttpResponse resp = client.sendRequest(8765, "http://localhost:9876");
    }
}
