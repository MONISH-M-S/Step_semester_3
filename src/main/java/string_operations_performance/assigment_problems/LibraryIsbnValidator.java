package string_operations_performance.assigment_problems;

public class LibraryIsbnValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisherCode + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        for (char c : publisherCode.toCharArray()) {
            if (!Character.isLetter(c)) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3);
        for (char c : body.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid: year/catalog must be digits";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        return "[" + publisherCode + "] YEAR: " + year + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {
        String raw1 = " pen2026004251 ";
        System.out.println(validateAndFormat(normalizeCode(raw1)));

        String raw2 = "12N2026004251";
        System.out.println(validateAndFormat(raw2));
    }
}
