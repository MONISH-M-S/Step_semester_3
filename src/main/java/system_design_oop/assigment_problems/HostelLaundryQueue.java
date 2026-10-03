package system_design_oop.assigment_problems;

public class HostelLaundryQueue {

    static abstract class WashType {
        abstract String getName();

        abstract int getDurationMinutes();

        abstract double getCharge();
    }

    static class QuickWash extends WashType {
        @Override
        String getName() {
            return "Quick";
        }

        @Override
        int getDurationMinutes() {
            return 30;
        }

        @Override
        double getCharge() {
            return 20;
        }
    }

    static class NormalWash extends WashType {
        @Override
        String getName() {
            return "Normal";
        }

        @Override
        int getDurationMinutes() {
            return 45;
        }

        @Override
        double getCharge() {
            return 30;
        }
    }

    static class HeavyWash extends WashType {
        @Override
        String getName() {
            return "Heavy";
        }

        @Override
        int getDurationMinutes() {
            return 60;
        }

        @Override
        double getCharge() {
            return 45;
        }
    }

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class WashingMachine {
        private String id;
        private boolean busy = false;

        public WashingMachine(String id) {
            this.id = id;
        }

        String getId() {
            return id;
        }

        boolean isBusy() {
            return busy;
        }

        void markBusy() {
            busy = true;
        }

        void markFree() {
            busy = false;
        }
    }

    static class LaundrySystem {
        String startWash(Student student, WashingMachine machine, WashType washType) {
            if (machine.isBusy()) {
                return "Machine " + machine.getId() + " is currently busy.";
            }
            machine.markBusy();
            return washType.getName() + " wash started on " + machine.getId() + " for " + student.name
                    + " (" + washType.getDurationMinutes() + " min). Charge: \u20B9"
                    + String.format("%.2f", washType.getCharge()) + ".";
        }

        String completeCycle(WashingMachine machine) {
            machine.markFree();
            return machine.getId() + " cycle completed. " + machine.getId() + " is now free.";
        }
    }

    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        LaundrySystem system = new LaundrySystem();

        System.out.println(system.startWash(asha, m1, new QuickWash()));
        System.out.println(system.startWash(ravi, m1, new HeavyWash()));
        System.out.println(system.startWash(ravi, m2, new HeavyWash()));
        System.out.println(system.completeCycle(m1));
        System.out.println(system.startWash(neha, m1, new NormalWash()));
    }
}
