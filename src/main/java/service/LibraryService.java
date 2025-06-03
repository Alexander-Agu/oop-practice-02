package service;

import model.Book;
import model.LibraryItem;
import model.Member;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibraryService(){
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // METHODS
    public void addBook(Book book){
        this.books.add(book);
    }

    public void registerMember(Member member){
        this.members.add(member);
    }


    public void borrowBook(String memberId, String bookId){
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member != null && book != null){
            if (book.isAvailable()){
                member.borrowItem(book);
                book.setAvailable(false);
            } else {
                System.out.println("Book is not available");
            }
        }else {
            System.out.println("Book or Member not found");
        }
    }


    public void returnBook(String memberId, String bookId){
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member != null && book != null){
            if (!book.isAvailable()){
                book.setAvailable(true);
                member.returnItem(book);
            }

        }else {
            System.out.println("Book or Member not found");
        }
    }


    public void listAvailableBooks(){
        if (!books.isEmpty()){
            int count = 0;

            System.out.println("Available Books");
            for (Book book: books){
                if (book.isAvailable()) {
                    count++;
                    System.out.println("Book " + count + " " + book.getTitle());
                }
            }
        }
    }


    public void listBorrowedBooksByMember(String memberId){
        Member member = findMember(memberId);

        if (member != null){
            member.displayBorrowedItems();
        } else {
            System.out.println("Member not found");
        }
    }


    // HELPER METHODS
    private Member findMember(String memberId){
        Member member = null;

        for(Member mem: members){
            if (mem.getMemberId().equalsIgnoreCase(memberId)) member = mem;
        }

        return member;
    }

    private Book findBook(String bookId){
        Book book = null;

        for (Book item: books){
            if (item.getId().equalsIgnoreCase(bookId)) book = item;
        }

        return book;
    }
}
