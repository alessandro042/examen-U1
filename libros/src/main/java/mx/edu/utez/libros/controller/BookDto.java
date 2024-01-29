package mx.edu.utez.libros.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.libros.model.libro.Book;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
public class BookDto {
private Long id;
private String bookname;
private String category;
private String author;
private String surnames;
private String isbn;
private LocalDate date;
private String pages;
private String invoice;

public Book toEntity(){
        return new Book(id, bookname, category, author, surnames, isbn, date, pages, invoice);
    }
    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", surnames='" + surnames + '\'' +
                ", isbn='" + isbn + '\'' +
                ", date=" + date +
                ", pages='" + pages + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }

}
