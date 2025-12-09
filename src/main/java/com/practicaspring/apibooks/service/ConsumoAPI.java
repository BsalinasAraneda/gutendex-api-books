package com.practicaspring.apibooks.service;

import java.beans.Encoder;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class ConsumoAPI {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private final HttpClient httpClient;

    // https://gutendex.com/books/?languages=en,es&search=don%20quijote

    public ConsumoAPI() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getAllBooks() throws IOException, InterruptedException {
        //URI uri = uriGetAllBooks();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books/"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error HTTP: " + response.statusCode());
        }


        return response.body();
    }

    public String obtenerLibroPoNombre(String nombreLibro) throws IOException, InterruptedException {
        URI uri = uriObtenerLibroPorNombre(nombreLibro);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error HTTP: " + response.statusCode());
        }
        return response.body();
    }

    public URI uriObtenerLibroPorNombre(String nombreLibro) {
        String encodeUrl = URLEncoder.encode(String.valueOf(nombreLibro) , StandardCharsets.UTF_8);
        String url = URL_BASE +"?languages=en,es&"+"search=" + encodeUrl;
        return URI.create(url);
    }


}
