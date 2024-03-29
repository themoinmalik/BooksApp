package com.demo.security.book;

import com.demo.security.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@EnableCaching
public class BookService {

    private final BookRepository repository;

    public ResponseEntity<BookRequest> save(BookRequest request) {
        var book = Book.builder()
                .author(request.getAuthor())
                .isbn(request.getName())
                .build();
        repository.save(book);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }


    // find by Id
    @Cacheable(cacheNames = "Book", key = "#Id")
    public ResponseEntity<Book> findById(@PathVariable int Id){
        Book book = repository.findById(Id).orElseThrow(
                () -> new ResourceNotFoundException("no book is available for id {} -" + Id)
        );
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
}
