package com.practicaspring.apibooks.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * Record que almacena la respuesta del JSON que tiene el Array
 * con los datos de las categorias a las que pertenece el libro
 */

public record CategoriaLibroAPI(
        @JsonAlias("subjects") List<CategoriaLibroAPI> categoriaLibro
) {
}
