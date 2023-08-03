import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("A001","Martin");
        Author author2 = new Author("A002","Sahan");

        Book book = new Book("B001","Magulkama",author);
        Book book2 = new Book("B002","Hathpana",author2);

        book.setAuthor(author);
        book2.setAuthor(author2);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book2);

        session.persist(author);
        session.persist(author2);

        transaction.commit();
        session.close();
    }
}
