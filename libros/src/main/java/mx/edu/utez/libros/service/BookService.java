package mx.edu.utez.libros.service;

import lombok.Setter;
import mx.edu.utez.libros.config.ApiResponse;
import mx.edu.utez.libros.model.libro.Book;
import mx.edu.utez.libros.model.libro.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
public class BookService {
    private final BookRepository repository;


    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id) {
        return new ResponseEntity<>(new ApiResponse(repository.findById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<ApiResponse> save(Book book) {
        String a = String.valueOf(book.getAuthor().charAt(0));
        String b = String.valueOf(book.getBookname().charAt(0));
        String ls1 = String.valueOf(book.getSurnames().charAt(0));
        String ls2 = String.valueOf(book.getSurnames().charAt(1));
        String anio = String.valueOf(book.getDate().getYear());
        String e = anio.substring(2);
        String m = String.valueOf(book.getDate().getMonthValue());

        int d = book.getDate().getDayOfMonth();
        String formattedDay = String.format("%02d", d);
        String isbn1 = String.valueOf(book.getIsbn().charAt(0));
        String isbn2 = String.valueOf(book.getIsbn().charAt(1));
        String isbn3 = String.valueOf(book.getIsbn().charAt(2));
        String isbn4 = String.valueOf(book.getIsbn().charAt(3));
        Random random = new Random();
        char r1 = (char) (random.nextInt(26) + 'a');
        char r2 = (char) (random.nextInt(26) + 'a');
 book.setInvoice(b + a + ls1 + ls2 + anio + m + formattedDay + isbn1 + isbn2 + isbn3 + isbn4 + r1 + r2);
        Optional<Book> foundBook = repository.findByInvoice(book.getInvoice());
        if (foundBook.isPresent())
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true,"RecordAlreadyExist"), HttpStatus.BAD_REQUEST);
        book = repository.saveAndFlush(book);
        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(book), HttpStatus.OK), HttpStatus.OK);
    }


}
