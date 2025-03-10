package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Book;
import org.example.model.BookDate;
import org.example.service.BookLoader;
import org.example.service.BookService;

import java.util.List;
import java.util.Optional;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);
  public static void main(String[] args) {
    logger.info("Iniciando aplicación...");

    List<Book> bookList = BookLoader.loadBooks();
    BookService bookService = new BookService();
    Optional<BookDate> optFilteredBook = bookService.filter("Harry", bookList);

    if (optFilteredBook.isPresent()){
      final BookDate filteredBook = optFilteredBook.get();
      logger.info("Libro filtrado que ha sido publicado más reciente: id [{}] Título [{}] (Fecha: {}) NumeroPaginas [{}] Autor [{}]",
          filteredBook.getId(),
          filteredBook.getTitle(),
          filteredBook.getFormattedPublicationDate(),
          filteredBook.getPages(),
          filteredBook.getAuthor().getAuthorFullName());

    }

    final List<Book> sortedBookList = bookService.sortBooks(bookList);
    sortedBookList.forEach(book ->
        logger.info("Libro: {} | Fecha: {} | Biografía ({} caracteres)",
            book.getTitle(), book.getPublicationDate(), book.getAuthor().getBiography().length())
    );

    logger.info("Libros ordenados correctamente.");

    logger.info("Finalizando proceso de filtrado de libros.");
  }
}
