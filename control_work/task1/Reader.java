package task1;

public class Reader {
    public String name;
    public int number;
    public String faculty;
    public String bday;
    public int telephone;

    public Reader(String name, int number, String faculty, String bday, int telephone) {
        this.name = name;
        this.bday = bday;
        this.number = number;
        this.telephone = telephone;
        this.faculty = faculty;
    }

    public void takeBook(int n) {
        System.out.println("\n" + name + " взял " + n + " книг");
    }

    public void takeBook(String[] books) {
        System.out.print("\n" + name + " взял книги: ");
        for (String b : books) {
            System.out.print(b + ", ");
        }
    }

    public void takeBook(Book[] books) {
        System.out.print("\n" + name + " взял книги: ");
        for (Book b : books) {
            System.out.print(b + ", ");
        }
    }

    public void returnBook(int n) {
        System.out.println("\n" + name + " вернул " + n + " книг");
    }

    public void returnBook(String[] books) {
        System.out.print("\n" + name + " вернул книги: ");
        for (String b : books) {
            System.out.print(b + ", ");
        }
    }

    public void returnBook(Book[] books) {
        System.out.print("\n" + name + " вернул книги: ");
        for (Book b : books) {
            System.out.print(b + ", ");
        }
    }
}
