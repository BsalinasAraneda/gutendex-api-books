package com.practicaspring.apibooks.Principal;

import com.practicaspring.apibooks.DTOs.Datos;
import com.practicaspring.apibooks.DTOs.DatosLibro;
import com.practicaspring.apibooks.service.ConsumoAPI;
import com.practicaspring.apibooks.service.ConvierteDatos;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LanzarLibros {
    private static ConsumoAPI consumoAPI = new ConsumoAPI();
    private static ConvierteDatos conversorDatos = new ConvierteDatos();
    private static List<Datos> libroAPIList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void LanzarApi() throws IOException, InterruptedException {
        var jsonAllBooks = consumoAPI.getAllBooks();
        var jsonContenidoLibro = conversorDatos.otbenerDatos(jsonAllBooks, Datos.class);
        libroAPIList.add(jsonContenidoLibro);
        System.out.println(libroAPIList);

        libroAPIList.add(jsonContenidoLibro);

        System.out.println("*** 10 Libros mas descargando en GUTENDEX ***");
        jsonContenidoLibro.getDataFromLibros().stream()
                .filter(lib -> lib.totalDescargas() > 0) // Filtrando descargas mayor a 0
                .sorted(Comparator.comparing(DatosLibro::totalDescargas).reversed()) // Comparando en cada instancia del libro de mayor a menor
                .limit(10) // Limitando a 5 la cantidad de libros
                .forEach(lib ->
                        System.out.println(
                                "Titulo: " + lib.tituloLibro() +
                                        " -Total descargas: " + lib.totalDescargas()
                        ));
        System.out.println("*** Buscando un libro en Gutendex ***");
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var libroBuscado = sc.nextLine();

        var jsonGetBookByName = consumoAPI.obtenerLibroPoNombre(libroBuscado);
        var jsonLibroBuscado = conversorDatos.otbenerDatos(jsonGetBookByName, Datos.class);

        Optional<DatosLibro> optionalLibro = jsonContenidoLibro.getDataFromLibros().stream()
                .filter(lib -> lib.tituloLibro().toUpperCase().contains(libroBuscado.toUpperCase()))
                .findFirst();

        if(optionalLibro.isPresent()){
            System.out.println("El libro se encontro con exito");
            System.out.println(jsonLibroBuscado);
        }else{
            System.out.println("El libro no se encuentra en nuestra biblioteca");
        }




        System.out.println("*** Generando Estadisticas ***");
        DoubleSummaryStatistics dst = jsonContenidoLibro.getDataFromLibros().stream()
                .filter(lib -> lib.totalDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibro::totalDescargas));

        System.out.println("Obteniendo información bruta desde Estadisticas");
        System.out.println("Total libros conteados: " + dst.getCount());
        System.out.println("Total de descargas: " + dst.getSum());
        System.out.println("Promedio general de descargas: " + dst.getAverage());
        System.out.println("Libro con menos de descargas: " + dst.getMin());
        System.out.println("Libro con mas descargas: " + dst.getMax());

    }

}
