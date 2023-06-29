package com.chat.client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.text.SimpleDateFormat;

public class Client {
    public static void main(String[] args) {
        String name = "empty";
        String reply = "empty";
        boolean time = false;
        String jawaban = "";
        String RESET = "\033[0m";
        Scanner sc = new Scanner(System.in);
        String mulai = "\t\tMulai percakapan? (y/n) ";
        Fitur fitur = new Fitur();
        fitur.interfaceAwal(mulai);
        
        jawaban = sc.nextLine();
        if (jawaban.toUpperCase().equals("Y")) {
            jawaban = mulai+jawaban;
            System.out.print(jawaban.format("\033[%dA",1)); // untuk move up
            System.out.print("\tMasukkan nama untuk bergabung dengan groupchat: " + RESET);
            reply = sc.nextLine();
            name = reply;
            String warna;

            try (Socket socket = new Socket("localhost", 5000)) { // 10.6.180.192
                // localhost dapat diganti menggunakan ip address computer server jika dijalankan
                // pada dua device atau lebih yang berbeda
                PrintWriter cout = new PrintWriter(socket.getOutputStream(), true);

                ThreadClient threadClient = new ThreadClient(socket);
                new Thread(threadClient).start(); // start thread to receive message

                cout.println(reply + ": has joined chat-room.");
                warna = fitur.warnaUser();
                do {
                    Date d = new Date();
                    SimpleDateFormat a = new SimpleDateFormat("hh:mm a");
                    String message = time ? ("\033[0;32m"+ a.format(d)+warna+ " "+name + RESET +" : ") : (warna+ name + RESET +" : ");
                    reply = sc.nextLine();
                    int count = 1; 
                    System.out.print(reply.format("\033[%dA",count));
                    System.out.print("\033[2K");
                    if(reply.toUpperCase().equals("WHATSUP!")||reply.toUpperCase().equals("WHATSUP")){
                        cout.print(warna+ name + RESET +" : ");
                        fitur.WhatsUp(cout);
                    }
                    else if (reply.toLowerCase().equals("logout")) {
                        cout.println("logout");
                        fitur.logout();
                        break;
                    }
                    else if(reply.toUpperCase().equals("STIME")){
                        System.out.println("Berhasil menambahkan waktu");
                        threadClient.setTime();
                        time = true;
                    }else if (reply.equals("ubah nama")){
                        String oldName;
                        oldName = name;
                        System.out.print("Masukkan namamu yang baru : ");
                        reply = sc.nextLine();
                        name = reply;
                        cout.println("\033[0;31m" + oldName + " telah mengubah nama menjadi "+ name + RESET);
                    }else if(reply.toLowerCase().equals("htime")){
                        System.out.println("Berhasil menyembunyikan waktu");
                        threadClient.hideTime();
                        time=false;
                    }
                    else{
                        System.out.println(message + reply);
                        cout.println(warna+ name + RESET +" : " + reply);
                    }
                } while (!reply.equals("logout"));
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
