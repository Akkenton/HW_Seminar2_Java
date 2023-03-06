package TASKS.task3;

/**
 * 3
 */
public class t3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        String str = "12221";
        System.out.println(palindrom(str));
    }

    static boolean palindrom(String str) {
        boolean flag = true;
        StringBuffer strB = new StringBuffer(str);

        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == strB.charAt((strB.length() - 1) - i)) {
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}