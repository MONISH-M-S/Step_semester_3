package linked_lists.class_problems;

import java.util.HashSet;
import java.util.Set;

public class StudentClubRegistration {

    static class Student {
        private final String roll;
        private final String name;

        Student(String roll, String name) {
            this.roll = roll;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Student)) {
                return false;
            }
            return roll.equals(((Student) o).roll);
        }

        @Override
        public int hashCode() {
            return roll.hashCode();
        }
    }

    public static void main(String[] args) {
        String[] ops = {
            "ADD 21CS01 Asha",
            "ADD 21CS01 Asha",
            "ADD 21CS02 Ravi",
            "CONTAINS 21CS02 Ravi",
            "CONTAINS 21CS03 Priya"
        };
        Set<Student> members = new HashSet<>();
        for (String op : ops) {
            String[] p = op.split(" ");
            if (p[0].equals("ADD")) {
                System.out.println(members.add(new Student(p[1], p[2])) ? "Added" : "duplicate rejected");
            }
        }
        System.out.println("member count " + members.size());
        for (String op : ops) {
            String[] p = op.split(" ");
            if (p[0].equals("CONTAINS")) {
                System.out.println("contains: " + members.contains(new Student(p[1], p[2])));
            }
        }
    }
}
