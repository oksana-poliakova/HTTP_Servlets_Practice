package http.socket.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */
public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        try (var datagramServer = new DatagramSocket(7777)) { // Create a datagram socket that listens on port 7777
            byte[] buffer = new byte[512]; // Create a byte array to store received data
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // Create a datagram packet to receive data
            datagramServer.receive(packet); // Receive data from the client and store it in the packet

            System.out.println(new String(buffer)); // Convert the received data to a string and print it
        }
    }

}
