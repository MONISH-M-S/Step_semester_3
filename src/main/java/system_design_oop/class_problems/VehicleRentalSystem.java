package system_design_oop.class_problems;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    static abstract class Vehicle {
        private String id;
        private boolean available = true;

        public Vehicle(String id) {
            this.id = id;
        }

        public abstract double calculateCharge(int days);

        String getId() {
            return id;
        }

        boolean isAvailable() {
            return available;
        }

        void markRented() {
            available = false;
        }

        void markAvailable() {
            available = true;
        }
    }

    static class Sedan extends Vehicle {
        public Sedan(String id) {
            super(id);
        }

        @Override
        public double calculateCharge(int days) {
            return days * 50.0;
        }
    }

    static class SUV extends Vehicle {
        public SUV(String id) {
            super(id);
        }

        @Override
        public double calculateCharge(int days) {
            return days * 70.0;
        }
    }

    static class Truck extends Vehicle {
        public Truck(String id) {
            super(id);
        }

        @Override
        public double calculateCharge(int days) {
            return days * 90.0;
        }
    }

    static class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Rental {
        Vehicle vehicle;
        Customer customer;
        int days;
        double charge;

        Rental(Vehicle vehicle, Customer customer, int days) {
            this.vehicle = vehicle;
            this.customer = customer;
            this.days = days;
            this.charge = vehicle.calculateCharge(days);
        }
    }

    static class RentalSystem {
        private List<Rental> activeRentals = new ArrayList<>();

        String rent(Vehicle vehicle, Customer customer, int days) {
            if (!vehicle.isAvailable()) {
                return vehicle.getId() + " is currently unavailable.";
            }
            vehicle.markRented();
            Rental rental = new Rental(vehicle, customer, days);
            activeRentals.add(rental);
            return vehicle.getId() + " rented successfully by " + customer.name
                    + ". Rental charge: $" + rental.charge;
        }

        String returnVehicle(Vehicle vehicle, Customer customer) {
            vehicle.markAvailable();
            return vehicle.getId() + " returned by " + customer.name;
        }
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        RentalSystem system = new RentalSystem();

        System.out.println(system.rent(sedanA, customer1, 3));
        System.out.println(system.rent(sedanA, customer2, 2));
        System.out.println(system.returnVehicle(sedanA, customer1));
        System.out.println(system.rent(suvB, customer3, 5));
    }
}
