package fr.lernejo.navy_battle;


import fr.lernejo.client.Client;
import fr.lernejo.server.Server;

import java.io.IOException;
import java.net.http.HttpRequest;


public class Launcher {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.init();
        Client client = new Client();
        HttpRequest req = client.init(Integer.parseInt(args[0]), args[1]);
    }
}
