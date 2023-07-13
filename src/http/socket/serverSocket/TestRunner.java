package http.socket.serverSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */
public class TestRunner {
    public static void main(String[] args) {
        try (var socket = new Socket("localhost", 7777); // Create a socket connection to the localhost on port 7777
             var outputStream = new DataOutputStream(socket.getOutputStream()); // Create a data output stream to write data to the socket
             var inputStream = new DataInputStream(socket.getInputStream()); // Create a data input stream to read data from the socket
             var scanner = new Scanner(System.in)) { // Create a scanner to read input from the console

            while (scanner.hasNextLine()) { // Enter the loop as long as there is input from the console
                String request = scanner.nextLine(); // Read the input from the console
                outputStream.writeUTF(request); // Send the request to the server via the socket
                String response = inputStream.readUTF(); // Read the response from the server via the socket
                System.out.println("Response from server: " + response); // Print the response from the server
            }

        } catch (IOException e) { // Handle any IOException that occurs during the execution
            e.printStackTrace(); // Print the stack trace of the exception
        }
    }
}
