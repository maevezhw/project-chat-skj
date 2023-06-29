package com.chat.client;

import java.io.PrintWriter;
import java.util.Random;

public class Fitur {
    public void ClearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public void interfaceAwal(String mulai){
        ClearScreen();
        System.out.println("\033[0;32m░██╗░░░░░░░██╗██╗░░██╗░█████╗░████████╗░██████╗██╗░░░██╗██████╗░██╗");
        System.out.println("░██║░░██╗░░██║██║░░██║██╔══██╗╚══██╔══╝██╔════╝██║░░░██║██╔══██╗██║");
        System.out.println("░╚██╗████╗██╔╝███████║███████║░░░██║░░░╚█████╗░██║░░░██║██████╔╝██║");
        System.out.println("░░████╔═████║░██╔══██║██╔══██║░░░██║░░░░╚═══██╗██║░░░██║██╔═══╝░╚═╝");
        System.out.println("░░╚██╔╝░╚██╔╝░██║░░██║██║░░██║░░░██║░░░██████╔╝╚██████╔╝██║░░░░░██╗");
        System.out.println("░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚═════╝░░╚═════╝░╚═╝░░░░░╚═╝"+"\033[0;34m");
        
        System.out.println("\n\t\tSelamat Datang di WhatsUp!\n");
        System.out.print(mulai+"\033[0;35m");
    }

    public void WhatsUp(PrintWriter cout){ // kea ping di bbm
        System.out.println("\033[0;35m──────▄▀▄─────▄▀▄");
        System.out.println("─────▄█░░▀▀▀▀▀░░█▄");
        System.out.println("─▄▄──█░░░░░░░░░░░█──▄▄");
        System.out.println("█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█");
        System.out.println("\033[0;34m WhatZupp!!^-^\033[0m");
        
        // cout.println("\033[0;35m──────▄▀▄─────▄▀▄");
        // cout.println("─────▄█░░▀▀▀▀▀░░█▄");
        // cout.println("─▄▄──█░░░░░░░░░░░█──▄▄");
        // cout.println("█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█\033[0m");
        // cout.println(nyoba);
        cout.println("\033[0;34m WhatZupp!! ^-^\033[0m");
    }

    String warnaUser(){
        String warna;
        Random rand = new Random();
        int random = Math.abs((rand.nextInt()) % 6);
        switch (random) {
            case 0:
                warna = "\033[0;31m";
                break;
            case 1:
                warna = "\033[0;32m";
                break;
            case 2:
                warna = "\033[0;33m";
                break;
            case 3:
                warna = "\033[0;34m";
                break;
            case 4:
                warna = "\033[0;35m";
                break;
            case 5:
                warna = "\033[0;36m";
                break;
            default:
                warna = "\033[0;37m";
        }
        return warna;
    }

    public void logout(){
        System.out.println("\033[0;33m██████╗░░█████╗░██████╗░░█████╗░██╗░░██╗░░░░░░░░░");
        System.out.println("██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░██║░░░░░░░░░");
        System.out.println("██║░░██║███████║██║░░██║███████║███████║░░░░░░░░░");
        System.out.println("██║░░██║██╔══██║██║░░██║██╔══██║██╔══██║░░░░░░░░░");
        System.out.println("██████╔╝██║░░██║██████╔╝██║░░██║██║░░██║██╗██╗██╗");
        System.out.println("╚═════╝░╚═╝░░╚═╝╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝╚═╝╚═╝\033[0m");
    }
    
}
