package classes_and_objects.class_problems;

class Student {
    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name) {
        this.name = name;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentStaticDemo {
    public static void main(String[] args) {
        new Student("Ravi");
        new Student("Meera");
        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}
