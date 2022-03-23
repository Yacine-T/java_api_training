package fr.lernejo.navy_battle;


import fr.lernejo.client.Client;
import fr.lernejo.server.Server;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server s1 = new Server(9876, "localhost");
        s1.init();
        Server s2 = new Server(8765, "localhost");
        s2.init();
        Client c1 = new Client(9876);
        HttpResponse rep1 = c1.sendRequest(9876, "http://localhost:8765");
        System.out.println("Reponse de s2 :" + rep1);
        Client c2 = new Client(8765);
        HttpResponse rep2 = c2.sendRequest(8765, "http://localhost:9876");
        System.out.println("Reponse de s1 :" + rep2);
    }
}
