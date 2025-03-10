package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;
import org.example.model.Book;
import org.example.model.BookDate;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class BookService {
  private static final Logger logger = LogManager.getLogger(Main.class);

  public Optional<BookDate> filter(String filter, List<Book> bookList){
    logger.info("Iniciando filtrado de libros que contengan [{}] en el título, en el resumen y en la biografía del autor.", filter);

    bookList.stream()
        .filter(book -> book.getPublicationDate() == null)
        .forEach(book -> logger.warn("Libro sin fecha de publicación: id - {} Titulo - {}", book.getId(),book.getTitle()));

    List<Book> filteredBooks = bookList.stream()
        .filter(book -> book.getTitle().toLowerCase().contains(filter.toLowerCase()) &&
                        book.getSummary().toLowerCase().contains(filter.toLowerCase()) &&
                        book.getAuthor().getBiography().toLowerCase().contains(filter.toLowerCase()))
        .collect(Collectors.toList());

    if (filteredBooks.isEmpty()) {
      logger.warn("No se han encontrado libros con el filtro especificado.");
      return Optional.empty();
    }
    logger.info("Se han encontrado {} libros que coinciden con el filtro [{}]", filteredBooks.size(), filter);

    return filteredBooks.stream()
        .max(Comparator.comparing(Book::getPublicationDate))
        .map(BookDate::new);
  }

  public List<Book> sortBooks(List<Book> books) {
    logger.info("Iniciando ordenación de libros agrupados por fecha de publicación y ordenados por longitud de la biografía del autor (de menos a mayor).");
    return books.stream()
        .collect(Collectors.groupingBy(book -> Optional.ofNullable(book.getPublicationDate()).orElse(LocalDate.MIN)))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByKey(Comparator.nullsFirst(Comparator.naturalOrder())))
        .flatMap(entry -> entry.getValue().stream()
            .sorted(Comparator.comparingInt(book -> book.getAuthor().getBiography().length())))
        .collect(Collectors.toList());
  }
}
