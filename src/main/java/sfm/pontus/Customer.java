/*
package sfm.pontus;

import javafx.collections.ObservableList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}

*/

package sfm.pontus;
/*
public class Customer {
    private int customer_id;
    private int customer_wallet;//Ft
    private String customer_name;
    private String password;
    //private ? cart;

}
*/
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue

     private int customer_id;

     private String customer_name;

     private String customer_email;

     private int customer_wallet;//Ft

     public int getCustomer_id() {   //Automatikusan kellene generálni.
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public int getCustomer_wallet() {
        return customer_wallet;
    }

    public void setCustomer_wallet(int customer_wallet) {
        this.customer_wallet = customer_wallet;
    }



}*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Account {

    private static final String VALID_PASSWORD_REGEX = "(?=^.{8,}$)(?=(.*[^A-Za-z]){2,})^.*";
    private static final String VALID_EMAIL_REGEX = "^(.+)@(.+)$";
    private String address;
    private String name;
    public Customer(String userName, String password, String name, String address) {
        super(userName, password);
        this.name = name;
        this.address = address;

    }

    public static boolean validateEmail(String email) {
        String pattern = VALID_EMAIL_REGEX;

        if (email.matches(pattern)) {
            return true;
        } else
            return false;
    }

    public static void add(String username, String password, String address, String name) {

        // App.executeQueryforUpdate("INSERT INTO customer (userName, password,address,name) VALUES ('"
        //         + username + "', '" + password + "','" + address + "','" + name + "')");


    }

    public static boolean validatePassword(String password) {
        String pattern = VALID_PASSWORD_REGEX;

        if (password.matches(pattern)) {
            return true;
        } else
            return false;
    }

    public static ObservableList<Customer> getListFromDB() {
/*
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        ResultSet rs = App.executeQueryforRS("SELECT * FROM customer");
        Customer customer;
        try {
            while (rs.next()) {
                customer = new Customer(rs.getString("userName"), rs.getString("password"),
                                         rs.getString("name"), rs.getString("address"));
                customer.id = rs.getInt("id");
                customerList.add(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;*/return null;

/*
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        ResultSet rs = App.executeQueryforRS("SELECT * FROM customer");
        Customer customer;
        try {
            while (rs.next()) {
                customer = new Customer(rs.getString("userName"), rs.getString("password"),
                                         rs.getString("name"), rs.getString("address"));
                customer.id = rs.getInt("id");
                customerList.add(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;*/
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String email) {
        setName(name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}