package http.socket.serverSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */
public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7777); // Create a server socket that listens on port 7777
             var socket = serverSocket.accept(); // Wait for a client to establish a connection with the server
             var outputStream = new DataOutputStream(socket.getOutputStream()); // Create a data output stream to send data to the client
             var inputStream = new DataInputStream(socket.getInputStream()); // Create a data input stream to receive data from the client
             var scanner = new Scanner(System.in)) { // Create a scanner to read input from the console

            var request = inputStream.readUTF(); // Read the client's request
            while (!"stop".equals(request)) { // Continue processing requests until the client sends the "stop" request
                System.out.println("Client request: " + request); // Print the client's request
                var response = scanner.nextLine(); // Read the response from the server
                outputStream.writeUTF(response); // Send the response to the client
                request = inputStream.readUTF(); // Read the next request from the client
            }
        }
    }

}
