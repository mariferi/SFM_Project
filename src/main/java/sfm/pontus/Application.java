package sfm.pontus;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws Exception {
        startDatabase();

        Customer customer2 = new Customer();
        customer2.setFirstName("Kiss");
        customer2.setLastName("Pista");

        try (CustomerDAO cDAO= new JpaCustomerDAO();){
            cDAO.saveCustomer(customer2);
        }

        /*
        Product prod =new Product();
        prod.setName("Televízió");
        */


        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:./src\\main\\resources\\mydb");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }
    /*
    public  void addCustomer(Customer customer){
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }
*/
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
