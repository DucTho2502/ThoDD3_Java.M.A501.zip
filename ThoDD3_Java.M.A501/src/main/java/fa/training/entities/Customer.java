package fa.training.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Customer implements Serializable{

    String name;
    String phoneNumber;
    String address;
    Set<Order> listOfOrder;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String address, Set<Order> listOfOrder) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.listOfOrder = listOfOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Order> getListOfOrder() {
        return listOfOrder;
    }

    public void setListOfOrder(Set<Order> listOfOrder) {
        this.listOfOrder = listOfOrder;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", listOfOrder=" + listOfOrder +
                '}';
    }
}
