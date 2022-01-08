package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import io.SerializeFileFactory;
import models.Customer;

public class CustomerManagementUI {
    static ArrayList<Customer> customers = new ArrayList<>();

    public void ui() {
        System.out.println("1. Nhập khách hàng");
        System.out.println("2. Xuất khách hàng");
        System.out.println("3. Tìm kiếm khách hàng");
        System.out.println("4. Sắp xếp khách hàng");
        System.out.println("5. Lưu khách hàng");
        System.out.println("6. Đọc khách hàng");
        System.out.println("7. Thống kê theo nhà mạng");
        System.out.println("8. Thoát phần mềm");
        int choose = 0;
        System.out.println("Bạn chọn chức năng [1..8]:");
        Scanner scanner = new Scanner(System.in);
        try {
            choose = scanner.nextInt();
        } catch (Exception e) {
            e.getStackTrace();
        }
        switch (choose) {
            case 1:
                importHandling();
                break;
            case 2:
                exportHandling();
                break;
            case 3:
                findHandling();
                break;
            case 4:
                sortHandling();
                break;
            case 5:
                saveHandling();
                break;
            case 6:
                readHandling();
                break;
            case 7:
                statisticalHandling();
                break;
            case 8:
                exitHandling();
                break;

            default:
                System.out.println("Chức năng bạn chọn không đúng.");
                break;
        }
        // scanner.close();
    }

    private void exitHandling() {
        System.out.println("Cám ơn bạn đã dùng phần mềm");
        System.exit(0);
    }

    private void statisticalHandling() {
        int n = 0;
        for (Customer customer : customers) {
            if (customer.getPhone().startsWith("098")) {
                n++;
            }
        }
        System.out.println("Có " + n + " khách hàng Viettel");
    }

    private void readHandling() {
        customers = SerializeFileFactory.readFile("D:\\java\\customersData.txt");
        System.out.println("Đọc file thành công");
    }

    private void saveHandling() {
        boolean result = SerializeFileFactory.saveFile(customers, "D:\\java\\customersData.txt");
        if (result) {
            System.out.println("Lưu file thành công");
        } else {
            System.out.println("Lưu file thất bại");
        }
    }

    private void sortHandling() {
        Collections.sort(customers);
        System.out.println("Đã sắp xếp");
    }

    private void findHandling() {
        // Chức năng: Mời bạn chọn đầu số.
        String phone = "090";
        System.out.println("==================================================");
        System.out.println("Khách hàng có đầu số 090:");
        System.out.println("Mã\tTên\tSố điện thoại");
        for (Customer customer : customers) {
            if (customer.getPhone().startsWith(phone)) {
                System.out.println(customer);
            }
        }
        System.out.println("==================================================");
    }

    private void exportHandling() {
        System.out.println("==================================================");
        System.out.println("Mã\tTên\tSố điện thoại");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println("==================================================");
    }

    private void importHandling() {
        try {
            Customer customer = new Customer();
            System.out.println("Mời bạn nhập mã:");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            System.out.println("Mời bạn nhập tên:");
            String name = scanner.nextLine();
            name = scanner.nextLine();
            System.out.println("Mời bạn nhập số điện thoại:");
            String phone = scanner.nextLine();

            customer.setId(id);
            customer.setName(name);
            customer.setPhone(phone);
            customers.add(customer);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

// xóa khách hàng trong 3 tháng gần đây không gọi.
