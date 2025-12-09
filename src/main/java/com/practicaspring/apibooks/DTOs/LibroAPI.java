package com.practicaspring.apibooks.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * Record que almacena la respuesta del JSON que tiene el Array
 * Corresponde a la cantidad de libros totales
 * y la respuesta correspondiente traida desde InnformacionLibroAPI
 */

public record LibroAPI(
        @JsonAlias("count") Integer totalLibrosAPI,
        @JsonAlias("results") List<InformacionLibroAPI> informacionLibro
) {
}
