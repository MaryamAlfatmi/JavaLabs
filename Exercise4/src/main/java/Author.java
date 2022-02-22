import java.util.ArrayList;

public class Author {

    private String name;
    private ArrayList<Books> booksList = new ArrayList<Books>();

    public Author(String name, Books book) {
        super();
        this.name = name.trim().replaceAll("\\s+", " ");
        this.addBook(book);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Books> getBooksList() {
        return booksList;
    }

    public void addBook(Books book) {
        this.booksList.add(book);
    }

    public ArrayList<Books> getAllBooks() {
        return null;
    }

    public boolean findBookInList(String bookName) {
        for (Books book : this.booksList) {
            if (book.getTitle().equals(bookName)) {
                return true;
            }
        }
        return false;
    }

}
