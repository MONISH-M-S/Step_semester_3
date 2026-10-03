package system_design_oop.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampusNoticeBroadcaster {

    interface NotificationChannel {
        String send(String studentName, String message);
    }

    static class EmailChannel implements NotificationChannel {
        @Override
        public String send(String studentName, String message) {
            return "[Email \u2192 " + studentName + "] " + message;
        }
    }

    static class SmsChannel implements NotificationChannel {
        @Override
        public String send(String studentName, String message) {
            return "[SMS \u2192 " + studentName + "] " + message;
        }
    }

    static class AppChannel implements NotificationChannel {
        @Override
        public String send(String studentName, String message) {
            return "[App \u2192 " + studentName + "] " + message;
        }
    }

    static class Student {
        String name;
        String department;
        List<NotificationChannel> channels;

        Student(String name, String department, List<NotificationChannel> channels) {
            this.name = name;
            this.department = department;
            this.channels = channels;
        }
    }

    static class NoticeBoard {
        private List<Student> students = new ArrayList<>();

        void addStudent(Student student) {
            students.add(student);
        }

        String postNotice(String title, List<String> departments) {
            if (title == null || title.trim().isEmpty()) {
                return "Cannot post notice: Title is required.";
            }
            if (departments == null || departments.isEmpty()) {
                return "Cannot post notice: At least one target department is required.";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Notice '").append(title).append("' posted to ").append(String.join(", ", departments)).append(".");
            for (Student student : students) {
                if (departments.contains(student.department)) {
                    for (NotificationChannel channel : student.channels) {
                        sb.append(" ").append(channel.send(student.name, title));
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Student asha = new Student("Asha", "CSE", Arrays.asList(new EmailChannel(), new AppChannel()));
        Student ravi = new Student("Ravi", "ECE", Arrays.asList(new SmsChannel()));

        NoticeBoard board = new NoticeBoard();
        board.addStudent(asha);
        board.addStudent(ravi);

        System.out.println(board.postNotice("Lab Closed Tomorrow", Arrays.asList("CSE")));
        System.out.println(board.postNotice("Fee Deadline Extended", Arrays.asList("CSE", "ECE")));
        System.out.println(board.postNotice("Sports Day", new ArrayList<>()));
    }
}
