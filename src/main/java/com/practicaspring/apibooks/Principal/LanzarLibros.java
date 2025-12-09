package com.practicaspring.apibooks.Principal;

import com.practicaspring.apibooks.DTOs.InformacionLibroAPI;
import com.practicaspring.apibooks.DTOs.LibroAPI;
import com.practicaspring.apibooks.service.ConsumoAPI;
import com.practicaspring.apibooks.service.ConvierteDatos;

import java.io.IOException;
import java.util.Scanner;

public class LanzarLibros {
    private static ConsumoAPI consumoAPI = new ConsumoAPI();
    private static ConvierteDatos conversorDatos = new ConvierteDatos();
    private static Scanner sc = new Scanner(System.in);

    public void LanzarApi() throws IOException, InterruptedException {
        var jsonAllBooks = consumoAPI.getAllBooks();
        var jsonContenidoLibro = conversorDatos.otbenerDatos(jsonAllBooks, LibroAPI.class);

        System.out.println("Ingrese el nombre del libro que desea buscar");
        var libroBuscado = sc.nextLine();

        var jsonGetBookByName = consumoAPI.obtenerLibroPoNombre(libroBuscado);
        var jsonLibroBuscado = conversorDatos.otbenerDatos(jsonGetBookByName, LibroAPI.class);
        System.out.println(jsonLibroBuscado);


    }

}
