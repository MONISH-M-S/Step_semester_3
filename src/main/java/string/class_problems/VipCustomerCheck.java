package string.class_problems;

public class VipCustomerCheck {

    static String validateCustomerId(String customerId) {
        return customerId.startsWith("VIP-") ? "VIP Customer" : "Regular Customer";
    }

    public static void main(String[] args) {
        String[] testIds = {"VIP-4589", "CUS-4589"};
        for (String id : testIds) {
            System.out.println("\"" + id + "\" -> " + validateCustomerId(id));
        }
    }
}
