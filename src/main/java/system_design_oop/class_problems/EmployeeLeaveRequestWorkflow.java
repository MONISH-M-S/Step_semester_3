package system_design_oop.class_problems;

public class EmployeeLeaveRequestWorkflow {

    static abstract class Employee {
        String name;

        public Employee(String name) {
            this.name = name;
        }

        public abstract boolean isEligibleForLeave(int days);
    }

    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name) {
            super(name);
        }

        @Override
        public boolean isEligibleForLeave(int days) {
            return true;
        }
    }

    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name) {
            super(name);
        }

        @Override
        public boolean isEligibleForLeave(int days) {
            return days <= 5;
        }
    }

    static class Contractor extends Employee {
        public Contractor(String name) {
            super(name);
        }

        @Override
        public boolean isEligibleForLeave(int days) {
            return false;
        }
    }

    static class LeaveRequest {
        private Employee employee;
        private String startDate;
        private String endDate;
        private String status = "Pending";

        public LeaveRequest(Employee employee, String startDate, String endDate) {
            this.employee = employee;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        String submittedMessage() {
            return "Leave request submitted for " + employee.name + " (" + startDate + "-" + endDate
                    + "). Status: " + status;
        }

        String approve() {
            if (!status.equals("Pending")) {
                return "Cannot change leave request status from " + status + " to Approved.";
            }
            status = "Approved";
            return employee.name + "'s leave request (" + startDate + "-" + endDate
                    + ") approved. Status: Approved";
        }

        String reject() {
            if (!status.equals("Pending")) {
                return "Cannot change leave request status from " + status + " to Rejected.";
            }
            status = "Rejected";
            return employee.name + "'s leave request (" + startDate + "-" + endDate
                    + ") rejected. Status: Rejected";
        }

        String setPending() {
            return "Cannot change leave request status from " + status + " to Pending.";
        }
    }

    public static void main(String[] args) {
        FullTimeEmployee john = new FullTimeEmployee("John");
        LeaveRequest johnRequest = new LeaveRequest(john, "Jan 1", "Jan 5");
        System.out.println(johnRequest.submittedMessage());
        System.out.println(johnRequest.approve());

        PartTimeEmployee jane = new PartTimeEmployee("Jane");
        LeaveRequest janeRequest = new LeaveRequest(jane, "Feb 10", "Feb 11");
        System.out.println(janeRequest.submittedMessage());
        System.out.println(janeRequest.reject());

        System.out.println(johnRequest.setPending());
    }
}
