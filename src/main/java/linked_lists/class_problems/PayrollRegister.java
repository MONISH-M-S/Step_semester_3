package linked_lists.class_problems;

public class PayrollRegister {

    static abstract class Staff {
        protected String name;

        Staff(String name) {
            this.name = name;
        }

        abstract String type();

        abstract long pay();

        @Override
        public String toString() {
            return "Payslip[name=" + name + ", type=" + type() + ", pay=" + pay() + "]";
        }
    }

    static class FullTime extends Staff {
        private long salary;

        FullTime(String name, long salary) {
            super(name);
            this.salary = salary;
        }

        String type() {
            return "FullTime";
        }

        long pay() {
            return salary;
        }
    }

    static class PartTime extends Staff {
        private long hours;
        private long rate;

        PartTime(String name, long hours, long rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        String type() {
            return "PartTime";
        }

        long pay() {
            return hours * rate;
        }
    }

    static class Intern extends Staff {
        private long stipend;

        Intern(String name, long stipend) {
            super(name);
            this.stipend = stipend;
        }

        String type() {
            return "Intern";
        }

        long pay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        String[] lines = {
            "FullTime Asha 50000",
            "PartTime Ravi 80 300",
            "Intern Neha 15000"
        };
        Staff[] register = new Staff[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] p = lines[i].split(" ");
            if (p[0].equals("FullTime")) {
                register[i] = new FullTime(p[1], Long.parseLong(p[2]));
            } else if (p[0].equals("PartTime")) {
                register[i] = new PartTime(p[1], Long.parseLong(p[2]), Long.parseLong(p[3]));
            } else {
                register[i] = new Intern(p[1], Long.parseLong(p[2]));
            }
        }
        long total = 0;
        Staff top = register[0];
        for (Staff s : register) {
            System.out.println(s);
            total += s.pay();
            if (s.pay() > top.pay()) {
                top = s;
            }
        }
        System.out.println("Total " + total);
        System.out.println("top earner " + top.name);
    }
}
