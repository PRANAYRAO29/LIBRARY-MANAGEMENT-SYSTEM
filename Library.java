import java.util.ArrayList;
import java.util.List;
class Library {
    private List<Book> books;
    public Library() {
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public boolean borrowBook(String title) {
        Book book = findBook(title);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            return true;
        }
        return false;
    }
    public boolean returnBook(String title) {
        Book book = findBook(title);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            return true;
        }
        return false;
    }
}

