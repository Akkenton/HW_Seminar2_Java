package TASKS.task4;

import java.util.logging.*;
import java.io.IOException;
import java.util.Scanner;

// К калькулятору из предыдущего дз добавить логирование.  
// делать дозапись в файл

public class t4 {
    public static void main(String[] args) throws SecurityException, IOException {

        // основной блок

        try (Scanner num = new Scanner(System.in, "Cp866")) {
            Logger logger = Logger.getLogger(t4.class.getName());
            logger.setLevel(Level.INFO);

            FileHandler fh = new FileHandler("logcalc.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            boolean contin = false;
            do {
                contin = CalcConstrBool(num, logger);
            } while (contin);
            num.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // метод расчетов у калькулятора из прошлого ДЗ
    // добавлено логирование в конструкции switch и обработчик продолжения

    static boolean CalcConstrBool(Scanner num, Logger logger) {
        System.out.println("\033[H\033[J");
        System.out.println("Введите первое число: ");
        int count1 = num.nextInt();
        System.out.println("Введите операцию(*,+,/,-): ");
        var znak = num.next();
        System.out.println("Введите второе число: ");
        int count2 = num.nextInt();

        int result;
        String resStr = new String();
        StringBuilder resultStrB = new StringBuilder();
        resultStrB.append(count1 + " ").append(znak + " ").append(count2 + " " + "=" + " ");

        switch (znak) {
            case "*":
                result = count1 * count2;
                resultStrB.append(result);
                resStr = resultStrB.toString();
                logger.info(resStr);
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

        boolean flag = false;
        System.out.println("Продолжаем расчеты?( Y/N");
        String decide = num.next();
        decide = decide.toLowerCase();
        switch (decide) {
            case "y":
                flag = true;
                break;
            case "n":
                flag = false;
                break;

            default:
                System.out.println("Прерывание цикла");
                break;
        }
        return flag;
    }
}
