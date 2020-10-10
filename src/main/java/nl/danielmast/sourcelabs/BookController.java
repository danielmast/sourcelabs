package nl.danielmast.sourcelabs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/book")
    public Book getBook() {
        return new Book(42, "The Lord of the Rings");
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return Arrays.asList(
            new Book(42, "The Lord of the Rings"),
            new Book(43, "Harry Potter"),
            new Book(44, "The Davinci Code")
        );
    }

    @GetMapping("/book_reactive")
    private Mono<Book> getBookReactive() {
        return Mono.just(new Book(45, "The Reactive Lord of the Rings"));
    }

    @GetMapping("/books_reactive")
    private Flux<Book> getBooksReactive() {
        return Flux.just(
            new Book(45, "The Reactive Lord of the Rings"),
            new Book(46, "Harry Reactive Potter"),
            new Book(47, "The Reactive Code")
        );
    }
}
