package stacks_linked_lists.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionTimetables {

    static class Timetable {
        private final String section;
        private final List<String> periods;

        Timetable(String section, List<String> periods) {
            this.section = section;
            this.periods = periods;
        }

        Timetable copy(String newSection) {
            return new Timetable(newSection, new ArrayList<>(periods));
        }

        void setPeriod(int period, String subject) {
            periods.set(period - 1, subject);
        }

        @Override
        public String toString() {
            return section + ": " + periods;
        }
    }

    public static void main(String[] args) {
        Timetable cseA = new Timetable("CSE-A", new ArrayList<>(Arrays.asList("Java", "DSA", "Maths")));
        Timetable cseB = cseA.copy("CSE-B");
        cseB.setPeriod(2, "Physics");
        System.out.println(cseA);
        System.out.println(cseB);
    }
}
