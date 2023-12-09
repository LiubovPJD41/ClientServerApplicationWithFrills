package Polyaeva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        String host = "netology.homework";
        int port = 801;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            readAndPrint(in);
            writeAndPrint("Liubov", out);
            readAndPrint(in);
            writeAndPrint("no", out);
            readAndPrint(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndPrint(BufferedReader in) throws IOException {
        String receivedMessage = in.readLine();
        System.out.println(receivedMessage);
    }

    private static void writeAndPrint(String message, PrintWriter out) {
        out.println(message);
        System.out.printf("Written: %s\n", message);
    }
}


