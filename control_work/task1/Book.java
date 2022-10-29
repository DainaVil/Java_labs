package task1;

public class Book {
    public String name;
    public String author;

    public Book(String name, String author) {
        this.author = author;
        this.name = name;
    }

    public Book(Book book) {
        this.author = book.author;
        this.name = book.name;
    }

    @Override
    public String toString(){
        return this.author + " - " + this.name;
    }

}
