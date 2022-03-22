package fr.lernejo.navy_battle;


import fr.lernejo.client.Client;
import fr.lernejo.server.Server;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.init();
        Client client = new Client();
        HttpResponse resp = client.sendRequest(Integer.parseInt(args[0]), args[1]);
        System.out.println(resp);
    }
}
