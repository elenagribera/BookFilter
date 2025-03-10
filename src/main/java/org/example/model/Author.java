package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static java.text.MessageFormat.format;

public class Author {
  private String name;
  private String firstSurname;
  @JsonProperty("bio")
  private String biography;

  public Author(){}
  public Author(String name,String firstSurname, String biography) {
    this.name = name;
    this.firstSurname = firstSurname;
    this.biography = biography;
  }
  public String getName() {
    return name;
  }

  public String getFirstSurname() {
    return firstSurname;
  }


  public String getAuthorFullName(){
    return (format("{0} {1}",name,firstSurname != null ? firstSurname : ""));
  }

  public String getBiography() {
    return biography;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFirstSurname(String firstSurname) {
    this.firstSurname = firstSurname;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }
}
