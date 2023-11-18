package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.company.Server.LOCALHOST_PORT;


public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        try (Socket clientSocket = new Socket(host, LOCALHOST_PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.println("Netology.ru");
            String resp = reader.readLine();
            System.out.println(resp);

            writer.println("no");
            String resp2 = reader.readLine();
            System.out.println(resp2);

            writer.println("Bye!");
            String resp3 = reader.readLine();
            System.out.println(resp3);

            writer.println("EXIT");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
