package mx.edu.utez.libros.model.libro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name="book")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String bookname;
    @Column(length = 50, nullable = false)
    private String category;
    @Column(length = 50, nullable = false)
    private String author;
    @Column(length = 50, nullable = false)
    private String surnames;
    @Column(length = 50, nullable = false, unique = true)
    private String isbn;
    @Column(columnDefinition = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @Column(length = 10, nullable = false)
    private String pages;
    @Column(length = 50)
    private String invoice;

    public Book(Long id, String bookname, String category, String author, String surnames, String isbn, LocalDate date, String pages, String invoice) {
        this.id = id;
        this.bookname = bookname;
        this.category = category;
        this.author = author;
        this.surnames = surnames;
        this.isbn = isbn;
        this.date = date;
        this.pages = pages;
        this.invoice = invoice;
    }
}
