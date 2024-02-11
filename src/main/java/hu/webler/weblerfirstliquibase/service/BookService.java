package hu.webler.weblerfirstliquibase.service;

import hu.webler.weblerfirstliquibase.entity.Book;
import hu.webler.weblerfirstliquibase.entity.Writer;
import hu.webler.weblerfirstliquibase.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final WriterService writerService;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        Writer existingWriter = writerService.findWriterByName(book.getWriter().getName());
        if (existingWriter != null) {
            book.setWriter(existingWriter);
        } else {
            Writer writer = new Writer();
            writer.setName(book.getWriter().getName());
            existingWriter = writerService.saveWriter(writer);
            book.setWriter(existingWriter);
        }
        return bookRepository.save(book);
    }
}
