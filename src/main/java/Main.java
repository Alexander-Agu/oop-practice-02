import model.Book;
import model.Member;
import service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryService libraryService = new LibraryService();
        rules();
        while (true){
            String input = scanner.nextLine();


            // If user wants to quit
            if (input.equalsIgnoreCase("exit")) break;


            // When user wants to add a book to the library
            else if(input.equalsIgnoreCase("add")){
                System.out.println("Add book name");
                String bookName = scanner.nextLine();

                System.out.println("Book Author");
                String author = scanner.nextLine();


                Book book = new Book(bookName, author);
                libraryService.addBook(book);
            }


            // Register member
            else if(input.equalsIgnoreCase("register")){
                System.out.println("Enter name");
                String name = scanner.nextLine();

                Member member = new Member(name);
                libraryService.registerMember(member);
            }


            // Member borrow book
            else if (input.equalsIgnoreCase("borrow")){
                System.out.println("Enter member id");
                String memberId = scanner.nextLine();

                System.out.println("Enter book id");
                String bookId = scanner.nextLine();

                libraryService.borrowBook(memberId, bookId);
            }


            // Return book
            else if (input.equalsIgnoreCase("return")){
                System.out.println("Enter member id");
                String memberId = scanner.nextLine();

                System.out.println("Enter book id");
                String bookId = scanner.nextLine();

                libraryService.returnBook(memberId, bookId);
            }


            // View available book
            else if (input.equalsIgnoreCase("view books")){
                libraryService.listAvailableBooks();
            }


            // View member's books
            else if(input.equalsIgnoreCase("view member")){
                System.out.println("Enter member id");
                String memberId = scanner.nextLine();

                libraryService.listBorrowedBooksByMember(memberId);
            }

            else if (input.equalsIgnoreCase("help")){
                rules();
            }else {
                rules();
            }

        }

        System.out.println("Testing done");
    }

    private static void rules(){
        System.out.println("HELP: available commands");
        System.out.println("EXIT: quit the program");
        System.out.println("ADD: add a book to the library");
        System.out.println("REGISTER: register member");
        System.out.println("BORROW: borrow a book");
        System.out.println("RETURN: return a book");
        System.out.println("VIEW BOOKS");
        System.out.println("VIEW MEMBER: view members books");
    }
}
