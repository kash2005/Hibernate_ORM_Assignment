import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId("B001");
        book.setName("Hathpana");

        Book book1 = new Book();
        book1.setId("B002");
        book1.setName("Magulkama");

        Author author = new Author();
        author.setId("A001");
        author.setName("Martin");

        Author author1 = new Author();
        author1.setId("A002");
        author.setName("Sahan");

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);

        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author1);

        author.setBooks(books);
        book.setAuthors(authors);
        author1.setBooks(books);
        book1.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(author);
        session.persist(book1);
        session.persist(author1);

        transaction.commit();
        session.close();
    }
}
