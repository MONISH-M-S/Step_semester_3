package string_operations_performance.class_problems;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.chars().allMatch(Character::isDigit)) {
            return "Invalid phone number";
        }
        String lastFour = phone.substring(6);
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.insert(masked.length(), "-" + lastFour);
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
