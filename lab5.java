import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab5 {
    public static void main(String[] args) {
        System.out.println(".");
        //1
        findNumbers("Цена продукта составляет 12.99, а другого - 150.");

        //2
        checkPassword("Short");
        checkPassword("LongPassword");
        checkPassword("CorrectPass123");

        //3
        highlightCaseChange("helloWorld");

        //4
        checkIP("192.168.10.11");
        checkIP("256.9.0.8");
        checkIP("10.0.0.255");

        //5
        findWordsStartingWith("Hello world, all world", 'w');
    }

    //1
    public static void findNumbers(String text) {
        try {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println("Найдено число: " + matcher.group());
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error in findNumbers: " + e.getMessage());
        }
    }

    //2
    public static void checkPassword(String password) {
        try {
            boolean lengthValid = Pattern.compile("^.{8,16}$").matcher(password).find();
            boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
            boolean hasDigit = Pattern.compile("\\d").matcher(password).find();

            if (!lengthValid || !hasUpperCase || !hasDigit) {
                System.out.println(password + " - некорректный пароль:");
                if (!lengthValid) {
                    System.out.println("  - длина должна быть от 8 до 16 символов.");
                }
                if (!hasUpperCase) {
                    System.out.println("  - должен содержать хотя бы одну заглавную букву.");
                }
                if (!hasDigit) {
                    System.out.println("  - должен содержать хотя бы одну цифру.");
                }
                
            } else {
                System.out.println(password + " - корректный пароль.");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error in checkPassword: " + e.getMessage());
        }
    }

    //3
    public static void highlightCaseChange(String text) {
        try {
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);
            String result = matcher.replaceAll("!$1$2!");
            System.out.println("Измененный текст: " + result);
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error in highlightCaseChange: " + e.getMessage());
        }
    }

    //4
    public static void checkIP(String ip) {
        try {
            String ipRegex = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$";
            Pattern pattern = Pattern.compile(ipRegex);
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println(ip + " - корректный IP-адрес.");
            } else {
                System.out.println(ip + " - некорректный IP-адрес.");
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error in checkIP: " + e.getMessage());
        }
    }

    //5
    public static void findWordsStartingWith(String text, char startChar) {
        try {
            String regex = "\\b" + startChar + "\\w*\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println("Найдено слово:" + matcher.group());
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error in findWordsStartingWith: " + e.getMessage());
        }
    }
}