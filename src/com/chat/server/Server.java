package com.chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.chat.client.Fitur;

public class Server {

    public static void main(String[] args) {
        Fitur fitur = new Fitur();
        ArrayList<Socket> clients = new ArrayList<>();
        HashMap<Socket, String> clientNameList = new HashMap<Socket, String>();
        try (ServerSocket serversocket = new ServerSocket(5000)) { // mendirikan server socket
            fitur.ClearScreen();
            System.out.println("Server is started...");
            while (true) {
                Socket socket = serversocket.accept(); // server socket buat socket
                clients.add(socket);
                ThreadServer ThreadServer = new ThreadServer(socket, clients, clientNameList);
                ThreadServer.start();
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
