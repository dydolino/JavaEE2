public class Book {

    private long id;
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book() {
    }

    public Book(String title, String author, String isbn, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }
    public Book(Long id, String title, String author, String isbn, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.isbn + ", Year: " + this.year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

