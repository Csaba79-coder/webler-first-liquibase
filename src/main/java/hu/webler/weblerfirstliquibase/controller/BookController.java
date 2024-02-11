package hu.webler.weblerfirstliquibase.controller;

import hu.webler.weblerfirstliquibase.entity.Book;
import hu.webler.weblerfirstliquibase.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> renderAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
