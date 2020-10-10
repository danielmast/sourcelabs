package nl.danielmast.sourcelabs;

public class Book {
    private final long id;
    private final String title;

    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
