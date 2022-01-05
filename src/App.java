import ui.CustomerManagementUI;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        CustomerManagementUI ui = new CustomerManagementUI();
        while (true) {
            ui.ui();
        }
    }
}
