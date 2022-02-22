import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryImplTest {

    private LibraryImpl library = new LibraryImpl();

    @Test
    public void getAuthorsFromBookName() {
        ArrayList<String> booksAuthor = new ArrayList<String>();
        booksAuthor.add("Suzanne Collins");
        assertEquals(booksAuthor, library.getAuthorsFromBookName("The Hunger Games"));
    }

    @Test
    public void writtenAllBooksInTheYear() {
        ArrayList<String> booksInGivenYear = new ArrayList<String>();
        booksInGivenYear.add("The Hunger Games");
        booksInGivenYear.add("Breaking Dawn");
        booksInGivenYear.add("The Host");
        booksInGivenYear.add("Paper Towns");
        assertEquals(booksInGivenYear, library.writtenAllBooksInTheYear(2008));
    }

}