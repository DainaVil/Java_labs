package task1;

public class Main {
    public static void main(String[] args) {
        var readers = new Reader[] {new Reader("Вилюнайте Д.М.", 12345, "ИТиАБД", "06.12.1999", 12345668), 
                            new Reader("Петров Вася", 12346, "ИТиАБД", "07.12.1999", 12345688) };
        var reader1 = readers[0];
        var reader2 = readers[1];

        var book1 = new Book("Анна Каренина", "Толстой");
        var book2 = new Book("Любовь Гика", "Кэтрин Данн");
        var books = new Book[] {book1, book2};

        reader1.takeBook(1);
        reader1.takeBook(new String[] {"Тру-Крайм","Фентези"});
        reader1.takeBook(books);

        reader2.returnBook(2);
        reader2.returnBook(new String[] {"Тру-Крайм","Фентези"});
        reader2.returnBook(books);

    }
}
