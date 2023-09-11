package Data;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class DataHelper {
    private static final Random random = new Random();

    public static String getApprovedCardNumber() {
        return "4444444444444441";
    }

    public static String getDeclinedCardNumber() {
        return "4444444444444442";
    }

    public static String getRandomCardNumber() {
        return generateRandomDigits(16);
    }

    public static String getRandomCardNumberWithLength() {
        int randomNumberLength = random.nextInt(16);
        return generateRandomDigits(randomNumberLength);
    }

    public static String getEmptyCardNumber() {
        return "";
    }

    public static String getOneMonthAgoMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneMonthAgo = currentDate.minusMonths(1);
        return oneMonthAgo.format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getCurrentYear() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        return String.format("%02d", currentYear % 100);
    }

    public static String getCurrentYearPlus6() {
        int currentYear = Integer.parseInt(getCurrentYear());
        int yearPlus6 = currentYear + 6;
        return String.format("%02d", yearPlus6 % 100);
    }

    public static String getPreviousYear() {
        int currentYear = Integer.parseInt(getCurrentYear());
        int previousYear = currentYear - 1;
        return String.format("%02d", previousYear % 100);
    }

    public static String getRandomMonth() {
        return String.format("%02d", random.nextInt(12) + 1);
    }

    public static String getInvalidMonth() {
        return "00";
    }

    public static String getEmptyMonth() {
        return "";
    }

    public static String getEmptyYear() {
        return "";
    }

    public static String getRandomYear() {
        return String.format("%02d", random.nextInt(6) + 24);
    }

    public static String getRandomOwnerName() {
        String[] names = {"Vadim", "Anton", "Dima", "Elena", "Ira", "Kristina", "Vladimir", "Katy"};
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }

    public static String getRandomOwnerNumber() {
        return String.valueOf(random.nextInt(10));
    }

    public static String getSpecialCharactersOwner() {
        return "!@#$%^&*()_+-";
    }

    public static String getEmptyOwner() {
        return "";
    }

    public static String getRandomCvc() {
        return generateRandomDigits(3);
    }

    public static String getSingleDigitCvc() {
        return generateRandomDigits(1);
    }

    public static String getDoubleDigitCvc() {
        return generateRandomDigits(2);
    }

    public static String getEmptyCvc() {
        return "";
    }

    private static String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}




