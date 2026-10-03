package system_design_oop.class_problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OnlineExaminationSystem {

    static abstract class Question {
        String label;
        String correctAnswer;
        int points;

        public Question(String label, String correctAnswer, int points) {
            this.label = label;
            this.correctAnswer = correctAnswer;
            this.points = points;
        }

        public abstract boolean isCorrect(String answer);
    }

    static class MultipleChoiceQuestion extends Question {
        public MultipleChoiceQuestion(String label, String correctAnswer, int points) {
            super(label, correctAnswer, points);
        }

        @Override
        public boolean isCorrect(String answer) {
            return correctAnswer.equalsIgnoreCase(answer);
        }
    }

    static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(String label, String correctAnswer, int points) {
            super(label, correctAnswer, points);
        }

        @Override
        public boolean isCorrect(String answer) {
            return correctAnswer.equalsIgnoreCase(answer);
        }
    }

    static class ShortAnswerQuestion extends Question {
        public ShortAnswerQuestion(String label, String correctAnswer, int points) {
            super(label, correctAnswer, points);
        }

        @Override
        public boolean isCorrect(String answer) {
            return correctAnswer.trim().equalsIgnoreCase(answer.trim());
        }
    }

    static class Examination {
        String name;
        List<Question> questions = new ArrayList<>();

        Examination(String name) {
            this.name = name;
        }

        void addQuestion(Question question) {
            questions.add(question);
        }
    }

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class Attempt {
        Student student;
        Examination exam;
        Map<String, String> answers = new LinkedHashMap<>();
        String status = "InProgress";

        Attempt(Student student, Examination exam) {
            this.student = student;
            this.exam = exam;
        }

        String recordAnswer(String label, String answer) {
            if (!status.equals("InProgress")) {
                return "Cannot change answers for a submitted examination.";
            }
            answers.put(label, answer);
            return "Answer recorded for " + label;
        }

        String submit() {
            status = "Submitted";
            StringBuilder sb = new StringBuilder("Result: ");
            int total = 0, max = 0;
            boolean first = true;
            for (Question q : exam.questions) {
                max += q.points;
                String given = answers.get(q.label);
                boolean correct = given != null && q.isCorrect(given);
                int scored = correct ? q.points : 0;
                total += scored;
                if (!first) {
                    sb.append(", ");
                }
                sb.append(q.label).append(": ").append(correct ? "Correct" : "Incorrect")
                        .append(" (").append(scored).append(" points)");
                first = false;
            }
            sb.append(". Total score: ").append(total).append("/").append(max).append(".");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Examination examA = new Examination("Exam A");
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("Question 1", "C", 5);
        TrueFalseQuestion q2 = new TrueFalseQuestion("Question 2", "False", 5);
        examA.addQuestion(q1);
        examA.addQuestion(q2);

        Student student1 = new Student("Student 1");
        Attempt attempt = new Attempt(student1, examA);

        System.out.println("Exam A started by " + student1.name);
        System.out.println(attempt.recordAnswer("Question 1", "C"));
        System.out.println(attempt.recordAnswer("Question 2", "True"));
        System.out.println("Exam A submitted by " + student1.name);
        System.out.println(attempt.submit());
        System.out.println(attempt.recordAnswer("Question 1", "B"));
    }
}
