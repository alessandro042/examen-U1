package mx.edu.utez.libros.model.libro;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{

    Optional<Book> findByInvoice(String invoice);
}
