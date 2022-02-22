import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LibraryImpl implements Library{

    private ArrayList<Author> authorList = new ArrayList<Author>();
    private static final String FILE_PATH = "src/main/resources/Books.csv";

    public LibraryImpl() {
        try (Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';')
                     .withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            for (CSVRecord csvRecord : csvParser) {
                // to get specific columns record from csv
                String authors = csvRecord.get("authors");
                String title = csvRecord.get("original_title");
                float year = Float.parseFloat(csvRecord.get("original_publication_year"));
                Double rating = Double.parseDouble(csvRecord.get("average_rating"));
                System.out.println("Authors:" + authors);
                System.out.println("Books:" + title);
                System.out.println("year:" + year);
                System.out.println("rating:" + rating);

                Books book = new Books(title, (int) year, rating);

                String[] authorValues = authors.split(",");

                for (String s : authorValues) {
                    Author author = findAuthor(s);
                    // if author is not present in the library add it to the list
                    if (author == null) {
                        authorList.add(new Author(s, book));
                        System.out.println();
                    }
                    // else add the book in to the booksList of author
                    else {
                        author.addBook(book);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void displayRecordsOfBookUsingCriteria(int choice, String authorName) {
        Author author = findAuthor(authorName);
        if (author == null) {
            System.out.println("This author is not available in library");

        } else {
            ArrayList<Books> books = author.getAllBooks();
            if (choice == 1) {
                books.sort(Comparator.comparing(Books::getTitle));
            }
            if (choice == 2) {
                books.sort(Comparator.comparing(Books::getTitle));
                Collections.reverse(books);

            }
            if (choice == 3) {
                books.sort(Comparator.comparing(Books::getYear));

            }
            if (choice == 4) {
                books.sort(Comparator.comparing(Books::getYear));
                Collections.reverse(books);
            }
            if (choice == 5) {
                books.sort(Comparator.comparing(Books::getRating));
            }
            if (choice == 6) {
                books.sort(Comparator.comparing(Books::getRating));
                Collections.reverse(books);
            }

            System.out.println("Books of Given Author using criteria number " + choice + ":");
            for (int i = 0; i < books.size(); i++) {
                Books book = books.get(i);
                System.out.println("No. of Book :" + (i + 1));
                System.out.println("Name of Book :" + book.getTitle());
                System.out.println("Publication year of Book :" + book.getYear());
                System.out.println("Rating of Book :" + book.getRating());

            }
        }
    }

    public ArrayList<String> getAuthorsFromBookName(String bookName) {
        ArrayList<String> authorsForBook = new ArrayList<String>();
        for (int i = 0; i < authorList.size(); i++) {

            if (authorList.get(i).findBookInList(bookName)) {
                authorsForBook.add(authorList.get(i).getName());
            }

        }
        return authorsForBook;
    }

    public Author findAuthor(String name) {
        Author authorobj = null;
        for (int i = 0; i < authorList.size(); i++) {
            Author author = authorList.get(i);
            if (author.getName().equals(name)) {
                authorobj = author;

            }
        }
        return authorobj;

    }

    public ArrayList<String> writtenAllBooksInTheYear(int year) {
        ArrayList<String> booksInGivenYear = new ArrayList<String>();
        ArrayList<Books> booksList = new ArrayList<Books>();
        if (year < 0 || year > 9999) {
            System.out.println("Please enter the Valid Year");
            booksInGivenYear = null;
            return booksInGivenYear;
        } else {
            for (int i = 0; i < authorList.size(); i++) {
                booksList = authorList.get(i).getAllBooks();
                for (Books b : booksList) {
                    if (b.getYear() == year) {
                        if (!booksInGivenYear.contains(b.getTitle())) {
                            booksInGivenYear.add(b.getTitle());
                        }

                    }
                }
            }
            return booksInGivenYear;
        }
    }

    public void profilicAuthor() {
        int max = authorList.get(0).getBooksList().size();
        String prolificAuthor = "";
        for (int i = 1; i < authorList.size(); i++) {
            int curBookCount = authorList.get(i).getBooksList().size();
            if (curBookCount > max) {
                prolificAuthor = "";
                prolificAuthor = authorList.get(i).getName();
                max = curBookCount;
            } else if (curBookCount == max) {
                prolificAuthor = prolificAuthor + "," + authorList.get(i).getName();
            }
        }
        System.out.println("Prolific Author: " + prolificAuthor + " has been published " + max + " books");
    }
}
