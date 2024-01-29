package mx.edu.utez.libros.controller;

import mx.edu.utez.libros.config.ApiResponse;
import mx.edu.utez.libros.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = {"*"})
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll(){
        return service.findAll();
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody BookDto dto){
        System.out.println(dto);
        return service.save(dto.toEntity());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody BookDto dto, @PathVariable Long id){
        return service.save(dto.toEntity());
    }
}
