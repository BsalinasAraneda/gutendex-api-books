package com.practicaspring.apibooks.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * Record que almacena la respuesta del JSON que tiene el Array
 * con los datos del Autor del libro
 */

public record AutorAPI(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") String fechaNacimiento,
    @JsonAlias("death_year") String fechaDeceso
) {
}
