package system_design_oop.class_problems;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessingShoppingSystem {

    interface PaymentMethod {
        boolean processPayment(double amount);

        String getName();
    }

    static class CreditCardPayment implements PaymentMethod {
        @Override
        public boolean processPayment(double amount) {
            return true;
        }

        @Override
        public String getName() {
            return "Credit Card";
        }
    }

    static class PayPalPayment implements PaymentMethod {
        private boolean shouldSucceed;

        public PayPalPayment(boolean shouldSucceed) {
            this.shouldSucceed = shouldSucceed;
        }

        @Override
        public boolean processPayment(double amount) {
            return shouldSucceed;
        }

        @Override
        public String getName() {
            return "PayPal";
        }
    }

    static class BankTransferPayment implements PaymentMethod {
        @Override
        public boolean processPayment(double amount) {
            return true;
        }

        @Override
        public String getName() {
            return "Bank Transfer";
        }
    }

    static class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class OrderItem {
        Product product;
        int qty;

        OrderItem(Product product, int qty) {
            this.product = product;
            this.qty = qty;
        }

        double subtotal() {
            return product.price * qty;
        }
    }

    static class Order {
        String id;
        Customer customer;
        List<OrderItem> items = new ArrayList<>();
        String status = "Pending";

        Order(String id, Customer customer) {
            this.id = id;
            this.customer = customer;
        }

        void addItem(Product product, int qty) {
            items.add(new OrderItem(product, qty));
        }

        double getTotal() {
            double total = 0;
            for (OrderItem item : items) {
                total += item.subtotal();
            }
            return total;
        }

        String pay(PaymentMethod method) {
            if (items.isEmpty()) {
                return "Cannot process payment for an empty order.";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Payment initiated via ").append(method.getName()).append(" for Order ").append(id).append(". ");
            boolean success = method.processPayment(getTotal());
            if (success) {
                status = "Paid";
                sb.append("Payment for Order ").append(id).append(" successful. Order status: Paid");
            } else {
                sb.append("Payment for Order ").append(id).append(" failed. Order status: Pending");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Customer customerX = new Customer("Customer X");
        Customer customerY = new Customer("Customer Y");
        Customer customerZ = new Customer("Customer Z");

        Product productA = new Product("Product A", 100);
        Product productB = new Product("Product B", 50);
        Product productC = new Product("Product C", 75);

        Order orderX = new Order("X", customerX);
        orderX.addItem(productA, 2);
        orderX.addItem(productB, 1);
        System.out.println("Order created for Customer X.");
        System.out.println(orderX.pay(new CreditCardPayment()));

        Order orderY = new Order("Y", customerY);
        System.out.println(orderY.pay(new PayPalPayment(true)));

        Order orderZ = new Order("Z", customerZ);
        orderZ.addItem(productC, 1);
        System.out.println("Order created for Customer Z.");
        System.out.println(orderZ.pay(new PayPalPayment(false)));
    }
}
