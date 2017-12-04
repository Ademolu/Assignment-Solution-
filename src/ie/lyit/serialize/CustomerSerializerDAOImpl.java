package ie.lyit.serialize;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;

public class CustomerSerializerDAOImpl  implements CustomerSerializerDAO{
	private ArrayList<Customer> customerList = new ArrayList<>();// Customer List
	private static final String fileName = "CustomerData";
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	/**
	 * @param customer
	 *            this method simply add new customer object in ArrayList
	 */
	public void addCustomer(Customer customer) {
		customerList.add(customer);
		System.out.println("Customer Added successfully.");
	}

	/**
	 * @param customerNumber
	 *            this method display customer Details based on customer number.
	 */
	public void viewCustomer(int customerNumber) {
		for (Customer customer : customerList) {
			if (customer.getNumber() == customerNumber) {
				System.out.println("\nNumber\tCustomer Details");
				System.out.println(customerNumber + "\t" + customer);
				return;
			}
		}
		System.out.println("Customer Not Found.");
	}

	/**
	 * this method list all customer
	 */
	public void listAllCustomer() {
		System.out.println("\nNumber\tCustomer Details");
		for (Customer customer : customerList) {
			System.out.println(customer.getNumber() + "\t" + customer);
		}
	}

	/**
	 * @param customerNumber
	 * Edit Customer Details 
	 * @throws IOException 
	 */
	public void editCustomer(int customerNumber) throws IOException {
		int index = -1;
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getNumber() == customerNumber) {
				index = i;
				break;
			}
		}
		// if Customer is not found
		if (index == -1) {
			System.out.println("Customer Not Found.");
		} else {// Customer is found

			//give option to user for edit
			System.out.println("1.Change Name");
			System.out.println("2.Change Address");
			System.out.println("3.Change Phone Number");
			System.out.println("4.Change Email");

			System.out.print("\tPlease Enter your Choice : ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			Customer customer = customerList.get(index);
			switch (choice) {
			case 1:
				
				Name name = new Name();
				System.out.print("Enter New Title: ");
				name.setTitle(br.readLine());
				System.out.print("Enter New First Name: ");
				name.setFirstName(br.readLine());
				System.out.print("Enter New SurName: ");
				name.setSurname(br.readLine());
				customer.setName(name);
				break;
			case 2:
				System.out.print("Enter New Address: ");
				customer.setAddress(br.readLine());
				break;
			case 3:
				System.out.print("Enter New Phone Number: ");
				customer.setPhoneNumber(br.readLine());
				break;
			case 4:
				System.out.print("Enter New Email: ");
				customer.setEmailAddress(br.readLine());
				break;

			default:
				System.out.println("Wrong Choice");
				return;

			}//switch over
			customerList.set(index, customer);
			System.out.println("Customer Detail Edited Successfully. ");
		}//else 

	}

	/**
	 * @param customerNumber
	 *            this method is useful for delete customer from customer list
	 */
	public void deleteCustomer(int customerNumber) {

		ListIterator<Customer> iterator = customerList.listIterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.getNumber() == customerNumber) {
				iterator.remove();
				System.out.println("Customer Deleted Successfully.");
				return;
			}
		}
		System.out.println("Customer Not Found.");
	}

	/**
	 * Serialized customer arraylist and store all Customer Object in to file.
	 */
	public void serialize() {
		// save the object to file

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			for (Customer customer : customerList) {
				out.writeObject(customer);
			}
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Deserialized Customers objects from file and Store in array List.
	 * and set Next Number in Customer class so it's not start Number generation from 1.
	 */
	public void deserialize() {
		// read the object from file
		// save the object to file
		ObjectInputStream in = null;
		try {

			in = new ObjectInputStream(new FileInputStream(fileName));
			Customer c = null;

			while ((c = (Customer) in.readObject()) != null) {
				customerList.add(c);
				//set next higher number so when you create new customer is not allocated
				//number 1, but rather the next highest number in the ArrayList.
				Customer.setNextNumber(c.getNumber()+1);
			}
			in.close();
			
		} catch (Exception ex) {

		}
	}

}
