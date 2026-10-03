package system_design_oop.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {

    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM d");

    static abstract class Room {
        String id;
        private List<Reservation> reservations = new ArrayList<>();

        public Room(String id) {
            this.id = id;
        }

        public abstract double calculatePrice(int nights);

        String getId() {
            return id;
        }

        boolean isAvailable(LocalDate start, LocalDate end) {
            for (Reservation r : reservations) {
                if (r.active && start.isBefore(r.end) && end.isAfter(r.start)) {
                    return false;
                }
            }
            return true;
        }

        void addReservation(Reservation r) {
            reservations.add(r);
        }
    }

    static class StandardRoom extends Room {
        public StandardRoom(String id) {
            super(id);
        }

        @Override
        public double calculatePrice(int nights) {
            return nights * 100.0;
        }
    }

    static class DeluxeRoom extends Room {
        public DeluxeRoom(String id) {
            super(id);
        }

        @Override
        public double calculatePrice(int nights) {
            return nights * 150.0;
        }
    }

    static class Suite extends Room {
        public Suite(String id) {
            super(id);
        }

        @Override
        public double calculatePrice(int nights) {
            return nights * 250.0;
        }
    }

    static class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Reservation {
        Room room;
        Customer customer;
        LocalDate start;
        LocalDate end;
        double price;
        boolean active = true;

        Reservation(Room room, Customer customer, LocalDate start, LocalDate end) {
            this.room = room;
            this.customer = customer;
            this.start = start;
            this.end = end;
            int nights = (int) (end.toEpochDay() - start.toEpochDay());
            this.price = room.calculatePrice(nights);
        }

        void cancel() {
            active = false;
        }
    }

    static class HotelSystem {
        String checkAvailability(Room room, LocalDate start, LocalDate end) {
            if (room.isAvailable(start, end)) {
                return room.getId() + " is available from " + fmt.format(start) + " to " + fmt.format(end) + ".";
            }
            return room.getId() + " is not available from " + fmt.format(start) + " to " + fmt.format(end) + ".";
        }

        Object[] reserve(Room room, Customer customer, LocalDate start, LocalDate end) {
            if (!room.isAvailable(start, end)) {
                return new Object[]{null,
                        room.getId() + " is not available from " + fmt.format(start) + " to " + fmt.format(end) + "."};
            }
            Reservation r = new Reservation(room, customer, start, end);
            room.addReservation(r);
            String msg = "Reservation confirmed for " + customer.name + ", " + room.getId()
                    + " (" + fmt.format(start) + "-" + fmt.format(end) + "). Price: $" + r.price;
            return new Object[]{r, msg};
        }

        String cancel(Reservation r) {
            r.cancel();
            return "Reservation for " + r.customer.name + ", " + r.room.getId()
                    + " (" + fmt.format(r.start) + "-" + fmt.format(r.end) + ") cancelled successfully.";
        }
    }

    public static void main(String[] args) {
        Room standard101 = new StandardRoom("Standard Room 101");
        Room deluxe201 = new DeluxeRoom("Deluxe Room 201");
        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");
        HotelSystem system = new HotelSystem();

        LocalDate jan1 = LocalDate.of(2026, 1, 1);
        LocalDate jan5 = LocalDate.of(2026, 1, 5);
        System.out.println(system.checkAvailability(standard101, jan1, jan5));

        Object[] res1 = system.reserve(standard101, customerA, jan1, jan5);
        System.out.println(res1[1]);

        LocalDate jan3 = LocalDate.of(2026, 1, 3);
        LocalDate jan7 = LocalDate.of(2026, 1, 7);
        Object[] res2 = system.reserve(standard101, customerB, jan3, jan7);
        System.out.println(res2[1]);

        System.out.println(system.cancel((Reservation) res1[0]));

        LocalDate feb10 = LocalDate.of(2026, 2, 10);
        LocalDate feb12 = LocalDate.of(2026, 2, 12);
        Object[] res3 = system.reserve(deluxe201, customerC, feb10, feb12);
        System.out.println(res3[1]);
    }
}
