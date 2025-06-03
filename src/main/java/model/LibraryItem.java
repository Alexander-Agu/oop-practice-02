package model;

public abstract class LibraryItem {
    private static int count = 0;
    private String id;
    private String title;
    private boolean isAvailable;

    public LibraryItem(String title){
        count++;
        this.id = "" + count;
        this.title = title;
        this.isAvailable = true;
    }

    public abstract void displayInfo();


    // METHODS
    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}
