package fa.training.entities;

import java.io.Serializable;

public class Order implements Serializable {

    String number;
    String date;

    public Order() {
    }

    public Order(String number, String date) {
        this.number = number;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
