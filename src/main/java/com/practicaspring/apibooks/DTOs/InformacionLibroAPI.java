package com.practicaspring.apibooks.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public record InformacionLibroAPI(
        @JsonAlias("title") String tituloLibro,
        @JsonAlias("authors") List<AutorAPI> autorApi,
        @JsonAlias("summaries") List<String> descripcionLibro,
        @JsonAlias("download_count") Integer totalDescargas
) {
}
