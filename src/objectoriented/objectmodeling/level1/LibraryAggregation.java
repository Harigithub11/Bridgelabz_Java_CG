package objectoriented.objectmodeling.level1;

import java.util.ArrayList;

class LibraryAggregation {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String title) {
        books.add(title);
    }

    void showBooks() {
        for (String b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        LibraryAggregation library = new LibraryAggregation();
        library.addBook("Java");
        library.addBook("Python");
        library.showBooks();
    }
}
