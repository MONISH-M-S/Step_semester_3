package access_modifiers_encapsulation.class_problems;

public class SubclassTicketAccess {

    static class MovieTicket {
        protected double ticketPrice;

        public MovieTicket(double ticketPrice) {
            this.ticketPrice = ticketPrice;
        }
    }

    static class PremiumMovieTicket extends MovieTicket {
        public PremiumMovieTicket(double ticketPrice) {
            super(ticketPrice);
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
    }

    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
