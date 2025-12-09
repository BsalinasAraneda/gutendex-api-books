package com.practicaspring.apibooks.service;

public interface IConvierteDatos {
    <T> T otbenerDatos(String json, Class<T> clase);
}
