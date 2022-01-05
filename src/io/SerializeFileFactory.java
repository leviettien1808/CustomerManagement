package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Customer;

/**
 * SerializeFileFactory
 */
public class SerializeFileFactory {

    public static boolean saveFile(ArrayList<Customer> customers, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Customer> readFile(String path) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            customers = (ArrayList<Customer>) data;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}