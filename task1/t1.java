package TASKS.task1;

import java.util.logging.*;
import java.io.IOException;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

public class t1 {
    public static void main(String[] args) throws SecurityException, IOException {
        System.out.print("\033[H\033[J");

        // объявляем и настраиваем логгер для записи в файл
        Logger logger = Logger.getLogger(t1.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        // объявляем нужные переменные
        int[] array = new int[] { 3, 1, 4, 6, 5, 2 };
        int countTemp = 0;
        boolean flag = false;

        // тело программы: сортировка массива с запиьсю логов
        logger.info(PrintArray(array));
        while (!flag) {
            flag = true;
            for (int i = 0; i < array.length; i++) {
                if (i + 1 == 6)
                    break;
                if (array[i] > array[i + 1]) {
                    flag = false;
                    countTemp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = countTemp;
                }
            }
            if (!flag) { // Если flag == false, т.е. массив изменился - пишем в лог
                logger.info(PrintArray(array));
            }
        }
    }

    // метод вывода массива и конвертирование его в строку, для записи в лог
    static String PrintArray(int[] arr) {
        StringBuilder strArr = new StringBuilder();
        String strStr = new String();

        for (int i = 0; i < arr.length; i++) {
            strArr.append(arr[i]);
        }
        strStr = strArr.toString();
        return strStr;
    }

}
