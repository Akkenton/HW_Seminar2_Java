package TASKS.task4;

import java.util.logging.*;
import java.util.Scanner;

// К калькулятору из предыдущего дз добавить логирование.  

public class t4 {
    public static void main(String[] args) {
        System.out.println("\033[H\033[J");

        Logger logger = Logger.getLogger(t4.class.getName());
        logger.setLevel(Level.INFO);

        Scanner num = new Scanner(System.in, "Cp866");
        System.out.println("Введите первое число: ");
        int count1 = num.nextInt();
        System.out.println("Введите операцию(*,+,/,-): ");
        var znak = num.next();
        System.out.println("Введите второе число: ");
        int count2 = num.nextInt();
        num.close();

        int result;
        String resStr = new String();
        StringBuilder resultStrB = new StringBuilder();
        resultStrB.append(count1 + " ").append(znak + " ").append(count2 + " " + "=" + " ");

        switch (znak) {
            case "*":
                result = count1 * count2;

                break;
            case "/":
                result = count1 / count2;
                resultStrB.append(result);
                resStr = resultStrB.toString();
                logger.info(resStr);
                break;
            case "+":
                result = count1 + count2;
                resultStrB.append(result);
                resStr = resultStrB.toString();
                logger.info(resStr);
                break;
            case "-":
                result = count1 - count2;
                resultStrB.append(result);
                resStr = resultStrB.toString();
                logger.info(resStr);
                break;

            default:
                logger.info("Не верное выражение знака!");
                break;
        }
    }
}
