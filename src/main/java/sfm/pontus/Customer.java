package sfm.pontus;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;//name/passwd in Account
	private String address;

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", address='" + address + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}


	public void setId(final Integer id) {
		this.id = id;
	}

	public Customer(String userName, String password, String address) {
		super(userName, password);
		this.address = address;
	}

	public static boolean validateEmail(String email) {
		return email.matches(VALID_EMAIL_REGEX);
	}
	public static boolean validatePassword(String password) {
		return password.matches(VALID_PASSWORD_REGEX);
	}

	public static String validateLogin(String username, String password) throws Exception {
		try (CustomerDAO cDAO= new JpaCustomerDAO()) {
			Customer Test = cDAO.getCustomerbyName(username);

			if (username.isEmpty() || password.isEmpty()) {
				return "Enter username AND password";
			} else if (Test.getUserName().equals(username) && Test.getPassword().equals(password)) {
				return "Username AND Password OK";
			} else return "Wrong Username OR Password";
		}
	}
	//*******************MÓDÓSÍTANI KELL HOGY MEGHÍVJA A SAJÁT ADATBÁZIS METÓDUST***************************
	public static void add(String username, String password, String address, String name) {
		/*
		Application.executeQueryforUpdate("INSERT INTO customer (userName, password,address,name) VALUES ('"
				+ username + "', '" + password + "','" + address + "','" + name + "')");
		*/
		System.out.println("A regisztrált adatok:");
		System.out.println("Név: " + name);
		System.out.println("Felhasználónév: " + username);
		System.out.println("Jelszó: " + password);
		System.out.println("Postázási cím: " + address);
	}
	//**************************************************************************************************


}