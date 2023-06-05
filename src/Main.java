import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Order order = new Order();

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birth = fmt.parse(sc.next());

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();
        System.out.print("How many items to this order? ");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++){
            System.out.printf("Enter #%d item data: \n", i);
            System.out.print("Product name: ");
            String name_p = sc.next();
            System.out.print("Product price: ");
            double price_p = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity_p = sc.nextInt();
            OrderItem p1 = new OrderItem(quantity_p, price_p, new Product(name_p, price_p));
           order.addItem(p1);
        }

        order.setMoment(new Date());
        order.setStatus(OrderStatus.valueOf(status));
        order.setClient(new Client(name, email, birth));
        System.out.println();
        System.out.println(order);
        sc.close();
    }
}