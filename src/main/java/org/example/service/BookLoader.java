package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;


public class BookLoader {
  private static final Logger logger = LoggerFactory.getLogger(BookLoader.class);

  public static List<Book> loadBooks() {
    ObjectMapper objectMapper = new ObjectMapper();
    logger.info("Cargando los libros del listado");
    try (InputStream inputStream = BookLoader.class.getResourceAsStream("/books.json")) {
      List<Book> bookList = objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {});
      logger.info("Se han cargado {} libros desde el archivo JSON.", bookList.size());
      return bookList;
    } catch (Exception e) {
      logger.error("Error al cargar el listado de libros desde JSON", e);
      throw new RuntimeException("Error al cargar los libros del listado", e);
    }
  }
}
