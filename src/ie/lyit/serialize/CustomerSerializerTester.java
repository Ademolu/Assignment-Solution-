package ie.lyit.serialize;

import java.io.IOException;
import java.util.Scanner;

import ie.lyit.hotel.Customer;

public class CustomerSerializerTester {
	public static void main(String[] args) throws IOException {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		//Create New CustomerSerializer Class Object
		CustomerSerializerDAOImpl cus = new CustomerSerializerDAOImpl();
		//Deserialize Customers Object from File.and Populate Object in ArrayList
		cus.deserialize();
		
		do {
			System.out.println("\n\tMenu");
			System.out.println("1.Add New Customer");
			System.out.println("2.View Customer");
			System.out.println("3.List All Customer");
			System.out.println("4.Edit Customer");
			System.out.println("5.Delete Customer");
			System.out.println("0.Quit");
			System.out.print("\tPlease Enter your Choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				cus.addCustomer(createNewCustomer());
				break;

			case 2:
				System.out.print("Please Enter Customer Number for View: ");

				cus.viewCustomer(sc.nextInt());
				break;
			case 3:
				cus.listAllCustomer();
				break;
			case 4:
				System.out.print("Please Enter Customer Number for Edit: ");
				cus.editCustomer(sc.nextInt());
				break;

			case 5:
				System.out.print("Please Enter Customer Number for Delete: ");
				cus.deleteCustomer(sc.nextInt());
				break;
			case 0:
				cus.serialize();
				System.out.println("Thanks...!!!");
				break;
			default:
				System.out.println("Wrong Input .Please try again.");
				break;
			}

		} while (choice != 0);

	}

	/**
	 * @return Customer
	 * this method take input from user and create new Customer Object.
	 * 
	 */
	public static Customer createNewCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Title(Mr,Ms): ");
		String title = sc.nextLine();
		System.out.print("Enter First Name: ");
		String fistName = sc.nextLine();
		System.out.print("Enter Surname: ");
		String surName = sc.nextLine();
		System.out.print("Enter Address: ");
		String address = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		Customer customer = new Customer(title, fistName, surName, address, phoneNumber, email);
		return customer;
	}
}
