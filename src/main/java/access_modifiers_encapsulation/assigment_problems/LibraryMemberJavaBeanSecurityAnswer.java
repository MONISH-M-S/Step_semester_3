package access_modifiers_encapsulation.assigment_problems;

public class LibraryMemberJavaBeanSecurityAnswer {

    static class LibraryMember {
        private String membershipId;
        private boolean membershipIdSet = false;
        private String name;
        private boolean premiumMember;
        private String securityAnswerHash;

        public LibraryMember() {
        }

        public String getMembershipId() {
            return membershipId;
        }

        public void setMembershipId(String id) {
            if (!membershipIdSet) {
                this.membershipId = id;
                this.membershipIdSet = true;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPremiumMember() {
            return premiumMember;
        }

        public void setPremiumMember(boolean premium) {
            this.premiumMember = premium;
        }

        public void setSecurityAnswer(String answer) {
            this.securityAnswerHash = "hashed:" + answer;
        }
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());

        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());

        System.out.println(m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
    }
}
