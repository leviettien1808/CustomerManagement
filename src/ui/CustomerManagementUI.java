package ui;

import java.util.ArrayList;
import java.util.Scanner;

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
        choose = scanner.nextInt();
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
                break;
        }
        scanner.close();
    }

    private void exitHandling() {
        System.out.println("Cám ơn bạn đã dùng phần mềm");
        System.exit(0);
    }

    private void statisticalHandling() {
    }

    private void readHandling() {
    }

    private void saveHandling() {
    }

    private void sortHandling() {
    }

    private void findHandling() {
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
        Customer customer=new Customer();
        System.out.println("Mời bạn nhập mã:");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        System.out.println("Mời bạn nhập tên:");
        String name=scanner.nextLine();
        name=scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại:");
        String phone=scanner.nextLine();

        customer.setId(id);
        customer.setName(name);
        customer.setPhone(phone);
        customers.add(customer);
    }
}
