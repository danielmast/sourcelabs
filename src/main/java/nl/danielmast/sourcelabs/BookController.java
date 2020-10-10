package nl.danielmast.sourcelabs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
