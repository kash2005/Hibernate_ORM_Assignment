import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("B001","Baddegama");
        Book book2 = new Book("B002","Hathpana");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book1);
        session.persist(book2);
        transaction.commit();

        Transaction transaction1 = session.beginTransaction();
        Book b001 = session.get(Book.class, "B001");
        transaction1.commit();

        Transaction transaction2 =  session.beginTransaction();
        if (b001 != null){
            book1.setName("Wassanaya");

            transaction2.commit();
        }

        Transaction transaction3 = session.beginTransaction();
        session.remove(book1);
        transaction3.commit();
    }
}
