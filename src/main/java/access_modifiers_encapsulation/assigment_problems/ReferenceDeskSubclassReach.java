package access_modifiers_encapsulation.assigment_problems;

public class ReferenceDeskSubclassReach {

    static class LibraryMember {
        protected double finesOwed;

        public LibraryMember(double finesOwed) {
            this.finesOwed = finesOwed;
        }
    }

    static class PremiumLibraryMember extends LibraryMember {
        public PremiumLibraryMember(double finesOwed) {
            super(finesOwed);
        }
    }

    static class AccessChecker {
        static String classifyAccess(String fieldModifier, String accessorContext) {
            switch (fieldModifier) {
                case "private":
                    return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
                case "default":
                    return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE"))
                            ? "ALLOWED" : "DENIED";
                case "protected":
                    if (accessorContext.equals("SAME_CLASS")
                            || accessorContext.equals("SAME_PACKAGE")
                            || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                        return "ALLOWED";
                    }
                    return "DENIED";
                case "public":
                    return "ALLOWED";
                default:
                    return "DENIED";
            }
        }

        static String firstDeniedAttempt(String[][] attempts) {
            for (int i = 0; i < attempts.length; i++) {
                String modifier = attempts[i][0];
                String context = attempts[i][1];
                if (classifyAccess(modifier, context).equals("DENIED")) {
                    return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
                }
            }
            return "None Denied";
        }
    }

    public static void main(String[] args) {
        String[][] batch1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(AccessChecker.firstDeniedAttempt(batch1));

        String[][] batch2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(AccessChecker.firstDeniedAttempt(batch2));
    }
}
