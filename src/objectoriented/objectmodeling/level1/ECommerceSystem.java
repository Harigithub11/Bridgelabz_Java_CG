package objectoriented.objectmodeling.level1;

import java.util.ArrayList;

class ECommerceSystem {
    String customer = "Hari";
    ArrayList<String> products = new ArrayList<>();

    void placeOrder() {
        products.add("Laptop");
        products.add("Mouse");
        System.out.println(customer + " placed order: " + products);
    }

    public static void main(String[] args) {
        ECommerceSystem e = new ECommerceSystem();
        e.placeOrder();
    }
}
