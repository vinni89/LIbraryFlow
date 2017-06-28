package ua.vinni.firstproject.springlibrary.entities;

/**
 * Created by Администратор on 16.10.2016.
 */
public class Vote {
    private long id;
    private int value;
    private long bookId;
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (value != vote.value) return false;
        if (bookId != vote.bookId) return false;
        if (username != null ? !username.equals(vote.username) : vote.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + value;
        result = 31 * result + (int) (bookId ^ (bookId >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
