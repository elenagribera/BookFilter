# Book Management System

This project is a Book Management System that allows you to load, filter, and sort books. It is built using Java and Maven.

## Features

- Load books from a JSON file
- Filter books based on the match of a given String in the title, summary, and author biography
- Sort the list of books given by publication date and author biography length.

## Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher

## Getting Started

### Clone the repository

```sh
git clone https://github.com/tyo-developer/book-management-system.git
cd book-management-system
```

### Build the project

```sh
mvn clean install
```

### Run the tests

```sh
mvn test
```


## Project Structure

- src/main/java/org/example/model/ - Contains the model classes (Book, Author, BookDate)
- src/main/java/org/example/service/ - Contains the service classes (BookLoader, BookService)
- src/test/java/org/example/service/ - Contains the test classes for the services

## Usage

### Loading Books

Books are loaded from a JSON file located at src/main/resources/books.json. The BookLoader class handles the loading of books.  

### Filtering Books

The BookService class provides a filter method to filter books based on a search string. The method returns the book with the latest publication date that matches the filter criteria.  

### Sorting Books

The BookService class also provides a sortBooks method to sort books by publication date and author biography length.



