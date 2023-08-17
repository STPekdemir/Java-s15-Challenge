package com.workintech.book;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Books {
    private Set<Book> books;

    public Books(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
    public void removeBookById(int id) {

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
            }
        }
    }
    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }


    public Book getBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }
    public Set<Book> getBooksByAuthor(String author) {
        Set<Book> authorBooks = new HashSet<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }
    public Set<Book> getBooksByGenre(Genre genre) {
        Set<Book> genreBooks = new HashSet<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }



    public void print() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
