package access_modifiers_encapsulation.assigment_problems;

import java.util.Arrays;

public class ImmutableLoanReceiptCirculationLedger {

    static class LoanReceipt {
        private final String memberId;
        private final String[] bookIds;

        public LoanReceipt(String memberId, String[] bookIds) {
            this.memberId = memberId;
            this.bookIds = bookIds.clone();
        }

        public String getMemberId() {
            return memberId;
        }

        public String[] getBookIds() {
            return bookIds.clone();
        }

        public LoanReceipt withCorrectedBookId(int index, String newId) {
            String[] updated = bookIds.clone();
            updated[index] = newId;
            return new LoanReceipt(memberId, updated);
        }
    }

    static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }
    }

    static class CirculationLedger {
        static String branchCode;

        static {
            branchCode = "PT-MAIN";
            System.out.println("Circulation ledger loaded for branch " + branchCode);
        }

        static String processNightlyCirculation(LoanReceipt[] receipts) {
            int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0;
            for (LoanReceipt r : receipts) {
                if (r == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (r instanceof ReferenceOnlyLoanReceipt) {
                    referenceOnly++;
                } else {
                    regular++;
                }
            }
            return processed + " processed | " + nullSkipped + " null skipped | "
                    + referenceOnly + " reference-only | " + regular + " regular";
        }
    }

    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(r.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] batch = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(batch));
    }
}
