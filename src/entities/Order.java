package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private Client client;


    public Order() {
    }

    public Order(Date moment, OrderStatus status,  Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy hh/mm/ss");

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

    public List<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0;
        for (OrderItem item: items){
            sum += item.subTotal();
        }
        return sum;
    }



    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ORDER SUMMARY: \n");
        s.append("Order moment: ");
        s.append(fmt1.format(moment) + "\n");
        s.append("Order status: " + status + "\n");
        s.append("Client: " + client.getName() + " (" + fmt.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
        s.append("Order items: \n");
        for (OrderItem c: items){
            s.append(c.getProduct().getName() + ", Quantity: " + c.getQuantity() + ", Subtotal: $" + String.format("%.2f",  c.subTotal()) + "\n");
        }
        s.append("Total price: " + String.format("%.2f", total()));

        return s.toString();
    }
}
