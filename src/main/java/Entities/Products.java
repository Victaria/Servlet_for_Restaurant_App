package Entities;

import java.util.Comparator;

public class Products implements Comparator {
    private int id;
    private String Name;
    private double price;
    private int amount;
    private static int lastId = 0;


    public Products(int id, String name, double price, int amount) {
        this.id = id;
        Name = name;
        this.price = price;
        this.amount = amount;
        setLastId(id);
    }

    public Products(Object o) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static int getLastId(){
        return lastId;
    }

    public static void setLastId(int id){
        if (lastId < id)
            lastId = id;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1.equals(o2)) return 0;
        else return -1;
    }
}
