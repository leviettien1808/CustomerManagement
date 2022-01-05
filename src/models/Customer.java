package models;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String name;
    private String phone;

    public Customer() {
        this.id = 0;
        this.name = "";
        this.phone = "";
    }

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.name + "\t" + this.phone;
    }
}
