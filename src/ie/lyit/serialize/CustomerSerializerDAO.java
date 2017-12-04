package ie.lyit.serialize;

import java.io.IOException;
import ie.lyit.hotel.Customer;

public interface CustomerSerializerDAO {
	/**
	 * @param customer
	 * Add new Customer 
	 */
	public void addCustomer(Customer customer) ;
	/**
	 * @param customerNumber
	 * View Customer detail by Customer Number
	 */
	public void viewCustomer(int customerNumber);
	/**
	 * List all Customer data
	 */
	public void listAllCustomer();
	/**
	 * @param customerNumber
	 * @throws IOException
	 * Edit already Existing customer details
	 */
	public void editCustomer(int customerNumber) throws IOException;
	/**
	 * @param customerNumber
	 * Delete customer by customer ID
	 */
	public void deleteCustomer(int customerNumber) ;
	/**
	 * Serialized Customer data  and save in to file
	 */
	public void serialize();
	/**
	 * deserialize customer data from file and store in arraylist
	 */
	public void deserialize();
}
