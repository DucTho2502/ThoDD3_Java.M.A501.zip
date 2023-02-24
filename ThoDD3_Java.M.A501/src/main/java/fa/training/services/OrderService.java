package fa.training.services;

import fa.training.entities.Order;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrderService {

    public Set<Order> createOrder(Scanner scanner, int maxSize) {
        String number, date;
        Order order;
        int count=0;

        Set<Order> orders = new HashSet<Order>();

        do {
            order = new Order();
            System.out.println("Enter number "+(count+1)+": ");
            number = Validate.inputStringLimit();
            order.setNumber(number);
            date = Validate.getString("Enter date", false, "empty");
            order.setDate(date);

            orders.add(order);
            count++;

        } while (count != maxSize);

        return orders;
    }
}
