package ua.vinni.firstproject.springlibrary.dao.interfaces;

import ua.vinni.firstproject.springlibrary.entities.Author;
import ua.vinni.firstproject.springlibrary.entities.Book;
import ua.vinni.firstproject.springlibrary.entities.Genre;

import java.util.List;

/**
 * Created by Администратор on 16.10.2016.
 */
public interface BookDao {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);
    Object getFieldValue(Long id, String fieldName);
}
