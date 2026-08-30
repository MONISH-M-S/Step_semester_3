package session_4.constructors_java_keywords.class_problems;

public class AccountBatchPayments {

    static class FeeAccount {
        String regNo;
        double amountPaid;

        public FeeAccount(String regNo) {
            this.regNo = regNo;
        }

        void pay(double amount) {
            amountPaid += amount;
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        public HostelFeeAccount(String regNo) {
            super(regNo);
        }

        void payInTwoInstallments(double amount) {
            pay(amount / 2);
            pay(amount / 2);
        }
    }

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostel = (HostelFeeAccount) account;
            hostel.payInTwoInstallments(amount);
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            account.pay(amount);
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount("H-01"),
            new HostelFeeAccount("H-02"),
            new FeeAccount("D-01"),
            new FeeAccount("D-02")
        };

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
