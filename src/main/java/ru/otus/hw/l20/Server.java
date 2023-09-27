package ru.otus.hw.l20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8088)) {

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String validOperations = "Valid operations: [+, -, * , /]";
                out.println(validOperations);

                String expression = in.readLine();
                System.out.println("Received: " + expression);

                String[] expressionParts = expression.trim().split("\\s+");
                int arg1 = Integer.parseInt(expressionParts[0]);
                int arg2 = Integer.parseInt(expressionParts[2]);
                String op = expressionParts[1];

                String result = switch (op) {
                    case "+" -> String.valueOf(arg1 + arg2);
                    case "-" -> String.valueOf(arg1 - arg2);
                    case "*" -> String.valueOf(arg1 * arg2);
                    case "/" -> (arg2 == 0) ? "You can't divide by 0" : String.valueOf(arg1 / arg2);
                    default -> "Invalid operation";
                };
                out.println(result);

                in.close();
                out.close();
                client.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
