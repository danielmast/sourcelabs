package nl.danielmast.sourcelabs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
public class BookControllerTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testGetBook() {
        WebTestClient client = WebTestClient
            .bindToApplicationContext(context)
            .build();

        Book book = new Book(42, "The Lord of the Rings");

        client.get()
            .uri("/book")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(Book.class)
            .isEqualTo(book);
    }

    @Test
    public void testGetBooks() {
        WebTestClient client = WebTestClient
            .bindToApplicationContext(context)
            .build();

        Book book = new Book(42, "The Lord of the Rings");

        client.get()
            .uri("/books")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBodyList(Book.class).hasSize(3).contains(book);
    }

    @Test
    public void testGetBookReactive() {
        WebTestClient client = WebTestClient
            .bindToApplicationContext(context)
            .build();

        Book book = new Book(45, "The Reactive Lord of the Rings");

        client.get()
            .uri("/book_reactive")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(Book.class)
            .isEqualTo(book);
    }

    @Test
    public void testGetBooksReactive() {
        WebTestClient client = WebTestClient
            .bindToApplicationContext(context)
            .build();

        Book book = new Book(45, "The Reactive Lord of the Rings");

        client.get()
            .uri("/books_reactive")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBodyList(Book.class).hasSize(3).contains(book);
    }

    @Test
    public void testGetBookRouter() {
        WebTestClient client = WebTestClient
            .bindToApplicationContext(context)
            .build();

        Book book = new Book(48, "Harry Router");

        client.get()
            .uri("/book_router")
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody(Book.class)
            .isEqualTo(book);
    }
}
