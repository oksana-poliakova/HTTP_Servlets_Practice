package http.socket.client;

import java.io.IOException;
import java.net.URL;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */
public class UrlExample {
    public static void main(String[] args) throws IOException {

        checkFile();
        checkGoogle();
    }

    // Read the input stream of the URL connection and convert it to a string
    private static void checkFile() throws IOException {

        var url = new URL("file:/Users/oksanapoliakova/Desktop/Java/HTTP_Servlets_Practice/src/http/socket/datagram/DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    // Method to retrieve and print header fields from a URL connection to "https://www.google.com"
    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();

        System.out.println(urlConnection.getHeaderFields());
    }
}
