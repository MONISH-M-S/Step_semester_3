package system_design_oop.assigment_problems;

import java.time.LocalDate;

public class AssignmentSubmissionPortal {

    static abstract class Assignment {
        String title;
        int maxMarks;
        LocalDate dueDate;

        public Assignment(String title, int maxMarks, LocalDate dueDate) {
            this.title = title;
            this.maxMarks = maxMarks;
            this.dueDate = dueDate;
        }

        abstract int getPenaltyPercentPerDay();

        double applyLatePenalty(double rawMarks, int daysLate) {
            int pct = Math.min(100, daysLate * getPenaltyPercentPerDay());
            return rawMarks * (100 - pct) / 100.0;
        }
    }

    static class CodingAssignment extends Assignment {
        public CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
            super(title, maxMarks, dueDate);
        }

        @Override
        int getPenaltyPercentPerDay() {
            return 10;
        }
    }

    static class WrittenAssignment extends Assignment {
        public WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
            super(title, maxMarks, dueDate);
        }

        @Override
        int getPenaltyPercentPerDay() {
            return 20;
        }
    }

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class Submission {
        Student student;
        Assignment assignment;
        LocalDate submittedDate;
        String status = "Submitted";
        int daysLate;

        Submission(Student student, Assignment assignment, LocalDate submittedDate) {
            this.student = student;
            this.assignment = assignment;
            this.submittedDate = submittedDate;
            this.daysLate = (int) Math.max(0, submittedDate.toEpochDay() - assignment.dueDate.toEpochDay());
        }

        String submissionMessage() {
            String lateText = daysLate > 0 ? " (" + daysLate + " days late)" : " (on time)";
            return student.name + "'s submission for '" + assignment.title + "' received" + lateText
                    + ". Status: Submitted";
        }

        String grade(double awardedMarks) {
            if (!status.equals("Submitted")) {
                return "Cannot resubmit: '" + assignment.title + "' has already been graded.";
            }
            String penaltyNote = "";
            double finalScore = awardedMarks;
            if (daysLate > 0) {
                int penaltyPct = Math.min(100, daysLate * assignment.getPenaltyPercentPerDay());
                finalScore = assignment.applyLatePenalty(awardedMarks, daysLate);
                penaltyNote = " after " + penaltyPct + "% late penalty";
            }
            status = "Graded";
            return student.name + " graded: " + Math.round(finalScore) + "/" + assignment.maxMarks
                    + penaltyNote + ". Status: Graded";
        }

        String attemptResubmit() {
            return "Cannot resubmit: '" + assignment.title + "' has already been graded.";
        }
    }

    public static void main(String[] args) {
        CodingAssignment linkedListLab = new CodingAssignment("Linked List Lab", 50, LocalDate.of(2026, 3, 10));
        WrittenAssignment designEssay = new WrittenAssignment("Design Essay", 50, LocalDate.of(2026, 3, 12));

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission ashaSub = new Submission(asha, linkedListLab, LocalDate.of(2026, 3, 10));
        System.out.println(ashaSub.submissionMessage());

        Submission raviSub = new Submission(ravi, designEssay, LocalDate.of(2026, 3, 14));
        System.out.println(raviSub.submissionMessage());

        System.out.println(ashaSub.grade(45));
        System.out.println(raviSub.grade(40));

        System.out.println(ashaSub.attemptResubmit());
    }
}
