import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat stdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.println("Name:");
		String name = scan.nextLine();
		System.out.println("Email");
		String email = scan.nextLine();
		System.out.println("Birth Date (DD/MM/YYYY)");
		String birthDate = scan.nextLine();
		Client client = new Client(name, email, stdf.parse(birthDate));

		System.out.println("Enter order data:");
		System.out.println("Status:");
		String status = scan.nextLine();
		OrderStatus orderStatus = OrderStatus.valueOf(status);
		Order order = new Order(orderStatus, client);
		System.out.println("How many items to this order");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {

			System.out.println("Enter #" + i + " item data");
			System.out.println("Product name:");
			String pName = scan.nextLine();
			System.out.println("Product price:");
			double pPrice = scan.nextDouble();
			Product product = new Product(pName, pPrice);
			System.out.println("Quantity:");
			int pQuantity = scan.nextInt();
			OrderItem orderItem = new OrderItem(pQuantity, pPrice, product);
			order.addItem(orderItem);

		}
		
		System.out.println("ORDER SUMMARY:");
		

	}

}
