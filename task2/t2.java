package TASKS.task2;

import java.io.BufferedReader;
import java.io.FileReader;

public class t2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        try {
            FileReader fr = new FileReader("1.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                line = line.replaceAll("\"", "");
                line = line.replace("фамилия:", "");
                line = line.replace("оценка:", "");
                line = line.replace("предмет:", "");
                String[] lineArr = line.split(",");
                System.out.printf("Студент %s получил %s по предмету %s \n", lineArr[0], lineArr[1], lineArr[2]);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
