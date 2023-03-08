package TASKS.task3;

/**
 * Напишите метод, который принимает на вход строку (String) и определяет
 * является ли строка палиндромом
 * (возвращает boolean значение). Без встр. функций
 */

// Сделан метод для строк без учета регистра

public class t3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        String str = "KABak";
        System.out.println(str);
        System.out.println(palindrom(str));
    }

    static boolean palindrom(String str) {
        boolean flag = true;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt((str.length() - 1) - i)) {
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}