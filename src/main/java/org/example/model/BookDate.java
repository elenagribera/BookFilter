package org.example.model;

import org.example.helper.Constants.DefaultValues;

import java.time.format.DateTimeFormatter;

public class BookDate extends Book {
  private final String formattedPublicationDate;
  public BookDate(Book book) {
    super(book);
    this.formattedPublicationDate = book.getPublicationDate() != null
        ? book.getPublicationDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"))
        : DefaultValues.EMPTY;
  }
  public String getFormattedPublicationDate() { return formattedPublicationDate; }
}
