package linked_lists.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccountWithdrawal {

    static abstract class Account {
        protected String id;
        protected long balance;

        Account(String id, long balance) {
            this.id = id;
            this.balance = balance;
        }

        abstract long floor();

        abstract String rejection();

        String withdraw(long amount) {
            if (balance - amount < floor()) {
                return id + " rejected: " + rejection();
            }
            balance -= amount;
            return id + " balance " + balance;
        }
    }

    static class Savings extends Account {
        Savings(String id, long balance) {
            super(id, balance);
        }

        long floor() {
            return 1000;
        }

        String rejection() {
            return "minimum balance 1000";
        }
    }

    static class Current extends Account {
        Current(String id, long balance) {
            super(id, balance);
        }

        long floor() {
            return -5000;
        }

        String rejection() {
            return "overdraft limit 5000";
        }
    }

    public static void main(String[] args) {
        String[] ops = {
            "Savings S1 5000",
            "WITHDRAW S1 4500",
            "Current C1 2000",
            "WITHDRAW C1 6000",
            "WITHDRAW S1 3000",
            "WITHDRAW C1 2000"
        };
        Map<String, Account> accounts = new LinkedHashMap<>();
        for (String op : ops) {
            String[] p = op.split(" ");
            if (p[0].equals("Savings")) {
                accounts.put(p[1], new Savings(p[1], Long.parseLong(p[2])));
            } else if (p[0].equals("Current")) {
                accounts.put(p[1], new Current(p[1], Long.parseLong(p[2])));
            } else {
                Account a = accounts.get(p[1]);
                if (a == null) {
                    System.out.println("Account not found");
                } else {
                    System.out.println(a.withdraw(Long.parseLong(p[2])));
                }
            }
        }
    }
}
