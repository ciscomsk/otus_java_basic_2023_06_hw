package ru.otus.hw.l20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (
                Socket client = new Socket("localhost", 8088);
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ) {
            System.out.println("Received: " + in.readLine());
            System.out.println("Enter expression: ");
            String expression = sc.nextLine();
            out.println(expression);

            String result = in.readLine();
            System.out.println("Received: " + result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
