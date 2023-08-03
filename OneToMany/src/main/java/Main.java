import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setId("A001");
        author.setName("Martin");

        Book book = new Book();
        book.setId("B001");
        book.setName("Hathpana");

        Book book2 = new Book();
        book2.setId("B002");
        book2.setName("Hathpana");

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.persist(author);
        session.persist(book);
        session.persist(book2);

        transaction.commit();
        session.close();
    }
}
