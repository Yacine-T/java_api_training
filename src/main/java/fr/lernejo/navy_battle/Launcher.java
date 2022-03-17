package fr.lernejo.navy_battle;

import fr.lernejo.MyHttpServer.MyHttpServer;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        MyHttpServer server = new MyHttpServer();
        server.init();
    }
}
