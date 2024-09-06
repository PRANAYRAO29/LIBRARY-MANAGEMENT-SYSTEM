import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        // Adding some initial books to the library
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display All Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    if (library.borrowBook(borrowTitle)) {
                        System.out.println("You borrowed " + borrowTitle);
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    if (library.returnBook(returnTitle)) {
                        System.out.println("You returned " + returnTitle);
                    } else {
                        System.out.println("Book not found or not borrowed.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added to the library.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

