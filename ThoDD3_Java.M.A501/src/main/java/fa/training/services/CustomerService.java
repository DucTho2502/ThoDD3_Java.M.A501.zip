package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Constant;

import java.io.*;
import java.util.*;

public class CustomerService {

    public static List<Customer> createCustomer(Scanner scanner){
        String loop, address;
        int numberOfOrder;
        Customer customer;
        Set<Order> orders = new HashSet<Order>();
        List<Customer> customers = new ArrayList<Customer>();
        OrderService orderService = new OrderService();

        do{
            customer = new Customer();

            String name = Validate.getString("Enter name of customer", false, "empty");
            customer.setName(name);
            String phoneNumber = Validate.checkPhone();
            customer.setPhoneNumber(phoneNumber);
            address = Validate.getString("Enter address of customer", false, "empty");
            customer.setAddress(address);

            System.out.println("================Enter order of customer=================");
            System.out.print("Enter number of order: ");
            numberOfOrder = Validate.checkInputInt();
            orders = orderService.createOrder(scanner, numberOfOrder);
            customer.setListOfOrder(orders);

            customers.add(customer);

            loop = Validate.getString("Do you want continue to input customer (Y/N)?: ", false, "empty");
        } while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
        return customers;
    }

    public static String save(List<Customer> customers) throws Exception {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constant.FILE_PATH1));
            objectOutputStream.writeObject(customers);
        } catch (Exception exception) {
            throw new Exception();
        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
        return Constant.SUCCESS;
    }

    public static List<Customer> getAll() throws IOException {
        ObjectInputStream objectInputStream = null;
        List<Customer> customers;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(
                    Constant.FILE_PATH1));
            customers = (List<Customer>) objectInputStream.readObject();
        } catch (Exception exception) {
            throw new IOException();
        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        }
        return customers;
    }

    public static void displayAll(List<Customer> customers) {
        System.out.println("---------------CUSTOMER LIST-------------------");
        System.out.format("%s%20s%20s%20s\n","Customer Name", "Address", "Phone Number", "OrderList");
        for (Customer customer: customers) {
            System.out.format("%s%30s%20s%20s\n",customer.getName(), customer.getAddress(), customer.getPhoneNumber(), customer.getListOfOrder());
        }
    }

    public static List<Customer> search(String phone) throws IOException {
        List<Customer> customers = new ArrayList<Customer>();
        List<Customer> result = new ArrayList<Customer>();
        if (customers != null) {
            customers.clear();
        }
        try {
            customers = CustomerService.getAll();
            if(customers == null){
                throw new Exception();
            }
            for (Customer customer: customers) {
                if(customer.getPhoneNumber().equals(phone)){
                    result.add(customer);
                }
            }
        } catch (IOException e){
            System.out.println("No data.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static boolean remove(String phone){
        List<Customer> customers = new ArrayList<Customer>();
        boolean result = false;
        if (customers != null) {
            customers.clear();
        }
        try {
            customers = CustomerService.getAll();
            if(customers == null){
                throw new Exception();
            }
            for (Customer customer: customers) {
                if(customer.getPhoneNumber().equals(phone)){
                    result = true;
                    customers.remove(customer);
                }
                break;
            }
        } catch (IOException e){
            System.out.println("No data.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(result){
            try {
                save(customers);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

}
