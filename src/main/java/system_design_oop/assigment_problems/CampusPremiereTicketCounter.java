package system_design_oop.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CampusPremiereTicketCounter {

    static abstract class Seat {
        String id;

        public Seat(String id) {
            this.id = id;
        }

        abstract double getPrice();
    }

    static class RegularSeat extends Seat {
        public RegularSeat(String id) {
            super(id);
        }

        @Override
        double getPrice() {
            return 150;
        }
    }

    static class PremiumSeat extends Seat {
        public PremiumSeat(String id) {
            super(id);
        }

        @Override
        double getPrice() {
            return 250;
        }
    }

    static class ReclinerSeat extends Seat {
        public ReclinerSeat(String id) {
            super(id);
        }

        @Override
        double getPrice() {
            return 400;
        }
    }

    static class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Show {
        String time;
        private Set<String> bookedSeatIds = new HashSet<>();

        Show(String time) {
            this.time = time;
        }

        boolean isBooked(String seatId) {
            return bookedSeatIds.contains(seatId);
        }

        void markBooked(String seatId) {
            bookedSeatIds.add(seatId);
        }

        void release(String seatId) {
            bookedSeatIds.remove(seatId);
        }
    }

    static class Booking {
        Customer customer;
        Show show;
        List<Seat> seats;
        double total;

        Booking(Customer customer, Show show, List<Seat> seats) {
            this.customer = customer;
            this.show = show;
            this.seats = seats;
            for (Seat s : seats) {
                total += s.getPrice();
            }
        }
    }

    static class TicketCounter {
        Object[] book(Customer customer, Show show, List<Seat> seats) {
            if (seats.size() > 6) {
                return new Object[]{null, "Cannot book more than 6 seats per booking."};
            }
            for (Seat s : seats) {
                if (show.isBooked(s.id)) {
                    return new Object[]{null, "Seat " + s.id + " is already booked for this show."};
                }
            }
            for (Seat s : seats) {
                show.markBooked(s.id);
            }
            Booking booking = new Booking(customer, show, seats);
            StringBuilder ids = new StringBuilder();
            for (int i = 0; i < seats.size(); i++) {
                if (i > 0) {
                    ids.append(", ");
                }
                ids.append(seats.get(i).id);
            }
            String msg = "Booking confirmed for " + customer.name + ": " + ids + ". Total: \u20B9"
                    + String.format("%.2f", booking.total);
            return new Object[]{booking, msg};
        }

        String cancel(Booking booking) {
            StringBuilder ids = new StringBuilder();
            for (int i = 0; i < booking.seats.size(); i++) {
                if (i > 0) {
                    ids.append(", ");
                }
                ids.append(booking.seats.get(i).id);
            }
            for (Seat s : booking.seats) {
                booking.show.release(s.id);
            }
            return booking.customer.name + "'s booking cancelled. Seats " + ids + " released.";
        }
    }

    public static void main(String[] args) {
        Show show7pm = new Show("7 PM");
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");
        TicketCounter counter = new TicketCounter();

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Object[] res1 = counter.book(asha, show7pm, Arrays.asList(a1, a2, f5));
        System.out.println(res1[1]);

        Seat a2Attempt = new RegularSeat("A2");
        Object[] res2 = counter.book(ravi, show7pm, Arrays.asList(a2Attempt));
        System.out.println(res2[1]);

        Seat r1 = new ReclinerSeat("R1");
        Object[] res3 = counter.book(ravi, show7pm, Arrays.asList(r1));
        System.out.println(res3[1]);

        System.out.println(counter.cancel((Booking) res1[0]));

        Seat a2Again = new RegularSeat("A2");
        Object[] res4 = counter.book(neha, show7pm, Arrays.asList(a2Again));
        System.out.println(res4[1]);
    }
}
