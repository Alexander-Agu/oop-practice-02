package model;

import java.util.ArrayList;

public class Member {
    private static int countMem = 0;
    private String memberId;
    private String name;
    private ArrayList<LibraryItem> borrowedItems;

    public Member(String name){
        countMem++;
        this.memberId = "" + countMem;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }


    // METHODS
    public void borrowItem(LibraryItem item){
        this.borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item){
        this.borrowedItems.remove(item);
    }

    public void displayBorrowedItems(){
        if (!borrowedItems.isEmpty()){
            int count = 0;


            System.out.println("Borrowed Items");
            for(LibraryItem book: borrowedItems){
                count++;
                System.out.println("Item "+ count + ": " + book.getTitle());
            }
        } else {
            System.out.println("No Borrowed Items");
        }
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }


    // HELPER METHODS
    public LibraryItem findBook(String bookId){
        LibraryItem book = null;

        for (LibraryItem item: borrowedItems){
            if (item.getId().equalsIgnoreCase(bookId)) book = item;
        }

        return book;
    }
}
