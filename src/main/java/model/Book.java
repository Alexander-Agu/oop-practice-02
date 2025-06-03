package model;

public class Book extends LibraryItem{
    private String author;


    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Is Available: " + (isAvailable()? "Yes!": "No!"));
    }

    public String getAuthor(){
        return this.author;
    }
}
