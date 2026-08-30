package session_4.constructors_java_keywords.assigment_problems;

public class LibraryMembershipCardSetup {

    static class MembershipCard {
        static String libraryName;
        static String validUntil;

        static {
            libraryName = "SRM Central Library";
            validUntil = "May 2027";
            System.out.println("Library info loaded");
        }

        String studentName;

        public MembershipCard(String studentName) {
            this.studentName = studentName;
        }

        void printConfirmation() {
            System.out.println("Membership card issued: " + studentName);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (String name : names) {
            MembershipCard card = new MembershipCard(name);
            card.printConfirmation();
        }
    }
}
