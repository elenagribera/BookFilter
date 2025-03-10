package org.example.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class Book {
  private int id;
  private String title;
  private Long publicationTimestamp;
  private int pages;
  private String summary;
  private Author author;


  public Book() {}
  public Book(Book book) {
    this.id = book.id;
    this.title = book.title;
    this.publicationTimestamp = book.publicationTimestamp;
    this.pages = book.pages;
    this.summary = book.summary;
    this.author = book.author;
  }

  public LocalDate getPublicationDate() {
    return Optional.ofNullable(publicationTimestamp)
        .map(ts -> Instant.ofEpochSecond(ts).atZone(ZoneId.systemDefault()).toLocalDate())
        .orElse(null);
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getSummary() {
    return summary;
  }

  public int getPages() {
    return pages;
  }

  public Author getAuthor() {
    return author;
  }

  public Long getPublicationTimestamp() {
    return publicationTimestamp;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setPublicationTimestamp(Long publicationTimestamp) {
    this.publicationTimestamp = publicationTimestamp;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
