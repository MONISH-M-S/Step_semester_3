package linked_lists.class_problems;

import java.util.HashMap;
import java.util.Map;

public class CampusVehiclePass {

    interface Chargeable {
        String bookBay();
    }

    static abstract class Vehicle {
        protected String passNumber;
        protected String owner;

        Vehicle(String passNumber, String owner) {
            this.passNumber = passNumber;
            this.owner = owner;
        }

        abstract String type();

        abstract int fee();
    }

    static class Bike extends Vehicle {
        Bike(String p, String o) {
            super(p, o);
        }

        String type() {
            return "Bike";
        }

        int fee() {
            return 300;
        }
    }

    static class Car extends Vehicle {
        Car(String p, String o) {
            super(p, o);
        }

        String type() {
            return "Car";
        }

        int fee() {
            return 1000;
        }
    }

    static class EBike extends Vehicle implements Chargeable {
        EBike(String p, String o) {
            super(p, o);
        }

        String type() {
            return "EBike";
        }

        int fee() {
            return 300;
        }

        public String bookBay() {
            return passNumber + " charging bay allotted";
        }
    }

    static class ECar extends Vehicle implements Chargeable {
        ECar(String p, String o) {
            super(p, o);
        }

        String type() {
            return "ECar";
        }

        int fee() {
            return 1000;
        }

        public String bookBay() {
            return passNumber + " charging bay allotted";
        }
    }

    public static void main(String[] args) {
        String[] ops = {
            "PASS Bike KA01 Asha",
            "PASS ECar KA02 Ravi",
            "CHARGE KA02",
            "CHARGE KA01"
        };
        Map<String, Vehicle> registry = new HashMap<>();
        for (String op : ops) {
            String[] p = op.split(" ");
            if (p[0].equals("PASS")) {
                Vehicle v;
                switch (p[1]) {
                    case "Bike":
                        v = new Bike(p[2], p[3]);
                        break;
                    case "Car":
                        v = new Car(p[2], p[3]);
                        break;
                    case "EBike":
                        v = new EBike(p[2], p[3]);
                        break;
                    default:
                        v = new ECar(p[2], p[3]);
                        break;
                }
                registry.put(v.passNumber, v);
                System.out.println(v.passNumber + " (" + v.type() + ") pass fee " + v.fee());
            } else {
                Vehicle v = registry.get(p[1]);
                if (v instanceof Chargeable) {
                    System.out.println(((Chargeable) v).bookBay());
                } else {
                    System.out.println(p[1] + " rejected: charging unsupported");
                }
            }
        }
    }
}
