package access_modifiers_encapsulation.class_problems;

public class SeatBookingEncapsulationGuard {

    static class CineScreen {
        private final int seatsTotal;
        private int seatsAvailable;

        public CineScreen(int seatsTotal) {
            if (seatsTotal <= 0) {
                throw new IllegalArgumentException("seatsTotal must be positive");
            }
            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
        }

        void bookSeat() {
            if (seatsAvailable > 0) {
                seatsAvailable--;
            }
        }

        void cancelBooking() {
            if (seatsAvailable < seatsTotal) {
                seatsAvailable++;
            }
        }

        int getSeatsAvailable() {
            return seatsAvailable;
        }
    }

    public static void main(String[] args) {
        try {
            new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("new CineScreen(0) construction rejected");
        }

        CineScreen c = new CineScreen(2);
        c.bookSeat();
        c.bookSeat();
        c.bookSeat();
        System.out.println(c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();
        System.out.println(c.getSeatsAvailable());
    }
}
