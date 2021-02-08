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
	private List<OrderItem> items = new ArrayList<>();

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

	public List<OrderItem> getItems() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double total() {
		double sum = 0;
		for (OrderItem it : items) {
			sum += it.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Likes - ");
		sb.append("ORDER SUMMARY:" + "\n");
		sb.append("Order moment: ");
		sb.append(stdf.format(moment) + "\n");
		sb.append("Order status:");
		sb.append(status.toString() + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " - " + client.getEmail() + "\n");
		sb.append("Order items:" + "\n");
		// parei AQUI
		return sb.toString();

	}

	public String itemsToString() {
		for (OrderItem ord : items) {
			return ord.getProduct().getName() + ", $" + ord.getProduct().getPrice() + ", Quantity:"
					+ ord.getQuantity() + ", Subtotal: $" + ord.subTotal();
			
		}
	}

}
