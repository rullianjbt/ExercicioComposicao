package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private SimpleDateFormat stdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {

	}

	public Order(OrderStatus status, Client client) {
		moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double total() {
		double sum = 0;
		for (OrderItem it : items) {
			sum += it.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(stdf.format(moment) + "\n");
		sb.append("Order status:");
		sb.append(status.toString() + "\n");
		sb.append("Client: ");
		sb.append(client.toString() + "\n");
		sb.append("Order items:" + "\n");

		for (OrderItem item : items) {
			sb.append(item.toString() + "\n");
		}

		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
