import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book("Harry Potter and the Philosopher's Stone", 1997, 4.44);

    @Test
    public void getTitle() {
        assertEquals("Harry Potter and the Philosopher's Stone", book.getTitle());
    }

    @Test
    public void getPublicationYear() {
        assertEquals(1997, book.getPublicationYear());
    }

    @Test
    public void getRating() {
        assertEquals(4.44, book.getRating(),0.0);
    }
}