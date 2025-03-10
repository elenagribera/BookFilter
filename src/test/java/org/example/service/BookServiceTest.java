package org.example.service;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.BookDate;
import org.junit.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class BookServiceTest {
    private final BookService service = new BookService();
  @Test
  public void testFilter() {
    Author author1 = new Author("Author A", "Surname A", "Biography A java");
    Author author2 = new Author("Author B","Surname B", "Biography java  B");

    Book book1 = new Book();
    book1.setTitle("Java Basics");
    book1.setSummary("A great book java");
    book1.setAuthor(author1);
    book1.setPublicationTimestamp(1234252540L);

    Book book2 = new Book();
    book2.setTitle("Advanced Java");
    book2.setSummary("Deep dive java");
    book2.setAuthor(author2);
    book2.setPublicationTimestamp(1185000940L);

    Optional<BookDate> result = service.filter("java", Arrays.asList(book1, book2));
    assertTrue(result.isPresent());
    assertEquals("Java Basics", result.get().getTitle());
  }
  @Test
  public void testFilterNoMatch() {
    Author author1 = new Author("Author A", "Surname A", "Biography A");
    Author author2 = new Author("Author B", "Surname B", "Biography B");

    Book book1 = new Book();
    book1.setTitle("Java Basics");
    book1.setSummary("A great book");
    book1.setAuthor(author1);
    book1.setPublicationTimestamp(Instant.parse("2022-01-01T00:00:00Z").getEpochSecond());

    Book book2 = new Book();
    book2.setTitle("Advanced Java");
    book2.setSummary("Deep dive");
    book2.setAuthor(author2);
    book2.setPublicationTimestamp(Instant.parse("2023-05-10T00:00:00Z").getEpochSecond());

    Optional<BookDate> result = service.filter("python", Arrays.asList(book1, book2));
    assertFalse(result.isPresent());
  }

}
