package string_operations_performance.class_problems;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (char c : bankCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (char c : body.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid: date/sequence must be digits";
            }
        }

        String date = reference.substring(3, 9);
        String seq = reference.substring(9);
        String dd = date.substring(0, 2);
        String mm = date.substring(2, 4);
        String yy = date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] DATE: ")
              .append(dd).append("/").append(mm).append("/").append(yy)
              .append(" | SEQ: ").append(seq);

        return result.toString();
    }

    public static void main(String[] args) {
        String raw1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(normalized1));

        String raw2 = "12F03022600042";
        System.out.println(validateAndFormat(raw2));
    }
}
