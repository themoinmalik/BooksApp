package com.demo.security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/books")
public class BookController {

    private final BookService service;

    @PostMapping("/create")
    public ResponseEntity<BookRequest> save(
            @RequestBody BookRequest request
    ) {
        return service.save(request);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Book> findById(@PathVariable Integer Id){
        return service.findById(Id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }
}
