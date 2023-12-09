package Polyaeva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 801;

        try (ServerSocket serverSocket = new ServerSocket(port)) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {

                    System.out.println("New connection accepted. Port:%d%n\", clientSocket.getPort()");

                    out.println("Write your name");

                    final String name = in.readLine();

                    out.println("Are you child? (yes/no)");

                    final String child = in.readLine();

                    if (child.equalsIgnoreCase("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!%n", name));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}