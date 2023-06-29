package com.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadClient implements Runnable {

    private Socket socket; 
    private BufferedReader cin;
    boolean time = false;

    public ThreadClient(Socket socket) throws IOException {
        this.socket = socket;
        this.cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } 

    public void setTime(){
        time = true;
    }

    public void hideTime(){
        time = false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Date d = new Date();
                SimpleDateFormat a = new SimpleDateFormat("hh:mm a");
                String message = cin.readLine();
                message = time? ("\033[0;32m"+ a.format(d) +"\033[0m " + message) : message;
                System.out.println(message);
            }
        } catch (SocketException e) {
            System.out.println("You left the chat-room");
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                cin.close();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
