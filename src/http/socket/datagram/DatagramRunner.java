package http.socket.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */

// UDP
public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        var inetAddress = InetAddress.getByName("localhost"); // Get the IP address of the localhost
        try (var datagramSocket = new DatagramSocket()) { // Create a datagram socket to send data
            var bytes = "Hello from UDP client".getBytes(); // Convert the message to bytes
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            // Create a datagram packet with the message, destination IP address (localhost), and port number 7777
            datagramSocket.send(packet); // Send the packet to the server
        }
    }
}
