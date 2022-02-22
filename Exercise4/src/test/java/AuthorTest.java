import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    private Book book = new Book("Twilight", 2005, 3.57);
    private Author auhtor = new Author("Stephenie Meyer", book);

    @Test
    public void getName() {
        assertEquals("Stephenie Meyer", auhtor.getAuthorName());
    }

    @Test
    public void findBookInList() {
        assertEquals(true, auhtor.findBookInList("Twilight"));
    }
}