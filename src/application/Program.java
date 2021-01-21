package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		
		Client client = new Client(name, email, date);
		
		System.out.print("Enter order data: ");
		String status = sc.next();
		Date d = new Date();
		Order order = new Order(d, OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.printf("Enter #%d item data: \n", i);
			System.out.print("Product Name: ");
			String productName = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem ITEM = new OrderItem(quantity, price, new Product(productName, price));
			order.addItem(ITEM);
		}

		
		System.out.println("ORDER SUMMARY: ");
		
		System.out.println(order);
		
		
		
		
		sc.close();
	}

}
