package system_design_oop.assigment_problems;

public class FitZoneMembershipDesk {

    static abstract class MembershipPlan {
        abstract String getName();

        abstract double calculateFee();
    }

    static class MonthlyPlan extends MembershipPlan {
        @Override
        String getName() {
            return "Monthly";
        }

        @Override
        double calculateFee() {
            return 1000.0;
        }
    }

    static class QuarterlyPlan extends MembershipPlan {
        @Override
        String getName() {
            return "Quarterly";
        }

        @Override
        double calculateFee() {
            return 3 * 1000.0 * 0.90;
        }
    }

    static class AnnualPlan extends MembershipPlan {
        @Override
        String getName() {
            return "Annual";
        }

        @Override
        double calculateFee() {
            return 12 * 1000.0 * 0.75;
        }
    }

    static class Member {
        String name;

        Member(String name) {
            this.name = name;
        }
    }

    static class Membership {
        Member member;
        MembershipPlan plan;
        String status = "Active";

        Membership(Member member, MembershipPlan plan) {
            this.member = member;
            this.plan = plan;
        }

        String creationMessage() {
            return plan.getName() + " membership created for " + member.name + ". Fee: \u20B9"
                    + String.format("%.2f", plan.calculateFee()) + ". Status: Active";
        }

        String checkIn() {
            if (!status.equals("Active")) {
                return "Check-in denied: " + member.name + "'s membership is " + status + ".";
            }
            return member.name + " checked in successfully.";
        }

        String freeze() {
            if (status.equals("Expired")) {
                return "Cannot freeze an Expired membership.";
            }
            status = "Frozen";
            return member.name + "'s membership frozen. Status: Frozen";
        }

        String unfreeze() {
            if (status.equals("Expired")) {
                return "Cannot unfreeze an Expired membership.";
            }
            status = "Active";
            return member.name + "'s membership unfrozen. Status: Active";
        }

        String expire() {
            status = "Expired";
            return member.name + "'s membership expired. Status: Expired";
        }
    }

    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership = new Membership(asha, new QuarterlyPlan());
        System.out.println(ashaMembership.creationMessage());

        Membership raviMembership = new Membership(ravi, new MonthlyPlan());
        System.out.println(raviMembership.creationMessage());

        System.out.println(ashaMembership.checkIn());
        System.out.println(ashaMembership.freeze());
        System.out.println(ashaMembership.checkIn());

        System.out.println(raviMembership.expire());
        System.out.println(raviMembership.freeze());
    }
}
