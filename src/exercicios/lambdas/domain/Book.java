package src.exercicios.lambdas.domain;

import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private Integer year;
    private List<String> authors;

    public Book(String title, Integer year, List<String> authors) {
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
