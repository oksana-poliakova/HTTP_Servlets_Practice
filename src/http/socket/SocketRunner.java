package http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */
public class SocketRunner {
    public static void main(String[] args) throws IOException {
        // ports: http - 80, https - 443, tcp
        // Create a socket connection to the IP address on port 80
        var inetAddress = Inet4Address.getByName("google.com");
        try (var socket = new Socket(inetAddress, 80);
             // Create data output stream for writing data to the socket
             var outputStream = new DataOutputStream(socket.getOutputStream());

             // Create data input stream for reading data from the socket
             var inputStream = new DataInputStream(socket.getInputStream())) {

            // Write the UTF-8 encoded string "Hello world!" to the socket output stream
            outputStream.writeUTF("Hello world!");

            // Read the response from the socket input stream as bytes
            var response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
