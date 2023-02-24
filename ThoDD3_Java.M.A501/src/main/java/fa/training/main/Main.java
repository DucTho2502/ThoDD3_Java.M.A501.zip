package fa.training.main;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.services.CustomerService;
import fa.training.services.Validate;
import fa.training.utils.Constant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Customer> customers;
    public static List<Order> orders;

    public static void main(String[] args) throws Exception {
        String choice, status;
        boolean remove = false;
        Scanner scanner = null;
        CustomerService customerService = new CustomerService();
        try {
            scanner = new Scanner(System.in);
            do {
                System.out.println("---------------------MENU--------------------");
                System.out.println("1. Add new customer"
                        + "\n2. Show all Customers"
                        + "\n3. Search Customer"
                        + "\n4. Remove Customer"
                        + "\n5. Exit ");

                System.out.println("Enter your choice: ");
                choice = scanner.nextLine();
                choice = choice.trim();
                switch (choice) {
                    case Constant.INPUT:
                        if (customers != null) {
                            customers.clear();
                        }
                        customers = CustomerService.createCustomer(scanner);
                        System.out.println("done");
                        try {
                            if (customers == null) {
                                throw new Exception();
                            }
                            status = CustomerService.save(customers);
                            System.out.println(status);
                        } catch (Exception e) {
                            System.out.println("fail");
                        }
                        break;
                    case Constant.DISPLAY:
                        if (customers != null) {
                            customers.clear();
                        }
                        try {
                            customers = CustomerService.getAll();
                            if(customers == null){
                                throw new Exception();
                            } CustomerService.displayAll(customers);
                        } catch (IOException e){
                            System.out.println("No data.");
                        }
                        break;
                    case Constant.SEARCH:
                        String phone = Validate.checkPhone();
                        customers = CustomerService.search(phone);
                        for (Customer customer: customers) {
                            System.out.println(customer);
                        }
                        break;
                    case Constant.REMOVE:
                        String phoneRemove = Validate.checkPhone();
                        try{
                            remove = CustomerService.remove(phoneRemove);
                            System.out.println("Remove: " + remove);
                        } catch (Exception e){
                            System.out.println("Remove Fail!");
                        }
                        break;
                }
            } while (!choice.equalsIgnoreCase(Constant.EXIT));
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }
}
