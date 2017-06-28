package ua.vinni.firstproject.springlibrary.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.vinni.firstproject.springlibrary.dao.interfaces.BookDao;
import ua.vinni.firstproject.springlibrary.entities.Author;
import ua.vinni.firstproject.springlibrary.entities.Book;

import java.util.List;

/**
 * Created by Администратор on 30.10.2016.
 */
@Component("libraryFacade")
@Scope("singleton")
public class LibraryFacade {

    private static final String FIELD_CONTENT = "content";

    @Autowired
    private BookDao bookDao;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<Book> books;

    /*public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
        books = bookDao.getBooks();
    }*/

    public List<Book> getBooks(){
        if (books == null){
            books = bookDao.getBooks();
        }
        return books;
    }

    public void searchBooksByLetter(){
        books = bookDao.getBooks(searchCriteria.getLetter());
    }

    public void searchBooksByGenre(){
        books = bookDao.getBooks(searchCriteria.getGenre());
    }

    public void searchBooksByText(){

        switch (searchCriteria.getSearchType()) {
            case TITLE:
                books = bookDao.getBooks(searchCriteria.getText());
                break;
            case AUTHOR:
                books = bookDao.getBooks(new Author(searchCriteria.getText()));
                break;
        }
    }

    public byte[] getContent(long id) {return (byte[])bookDao.getFieldValue(id, FIELD_CONTENT);}
}
