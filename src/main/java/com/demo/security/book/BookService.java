package com.demo.security.book;

import com.demo.security.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

//    public  save(BookRequest request) {
//        var book = Book.builder()
//                .id(request.getId())
//                .author(request.getAuthor())
//                .isbn(request.getIsbn())
//                .build();
//        repository.save(book);
//    }

    public ResponseEntity<BookRequest> save(BookRequest request){

        Book book = new Book();
//        book.setId(request.getId());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getName());
        repository.save(book);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    // find by Id.
    public ResponseEntity<Book> findById(@PathVariable int Id){
        Book book = repository.findById(Id).orElseThrow(
                () -> new ProductNotFoundException("no book is available for this id")
        );
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
}
