package http.socket.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

/**
 * @author Oksana Poliakova on 13.07.2023
 * @projectName HTTP_Servlets_Practice
 */
public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a new HttpClient instance
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        // Create a GET request to "https://www.google.com"
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();

        // Send the GET request and retrieve the response
        var response = httpClient.send(request, BodyHandlers.ofString());

        // Create a POST request to "https://www.google.com" with a file as the request body
        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
//                .POST(BodyPublishers.ofFile(Path.of("path", "to", "file")))
                .header("content-type", "text/plain")
                .build();

        System.out.println(response.body());
        System.out.println(response.headers());
    }
}
