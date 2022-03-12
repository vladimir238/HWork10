import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] arrYear = new int[6];
        String region="Дальневосточный";
        FileWriter writer = new FileWriter("src//output.txt", false);
        Scanner scanner = new Scanner(new FileInputStream("src/table.txt"));
        int i = 0;
        while (scanner.hasNextLine()) {
            i++;
            if (i == 1) {
                String[] year = scanner.nextLine().split(";");

                for (int s : stringArrInt(year)) System.out.println(s);
                arrYear = stringArrInt(year);
                System.out.println("Массив года ");


            } else {

                String[] volumeInfo = scanner.nextLine().split(";");
                //  FileWriter writer = new FileWriter("src//output.txt", true);
               // writer.write(resString.trim());

                if (townGet(volumeInfo[1]).trim().equals(region)) {
                    for (double s : stringArrDouble(volumeInfo)) System.out.println(s);
                    System.out.println("Массив урожая ");
                    double[] arrVolume = stringArrDouble(volumeInfo);
                    for (int f = 0; f < arrVolume.length - 1; f++) {
                        if (compNum(arrVolume[f], arrVolume[f + 1])) {
                          String s1= " Год ;" + arrYear[f] + ";" + arrYear[f + 1];
                          String s2=townGet(volumeInfo[0])+"  " + arrVolume[f] + " ; " + arrVolume[f + 1];
                          writer.write(s1);
                          writer.write("\n");
                          writer.write(s2);
                          writer.write("\n");
                          writer.flush();

                        }
                    }
                }

            }
        }
    }


    public static void solution(String district, int fromYear, int toYear) {
    }
// Возвращает массив чисел из строки

    public static int[] stringArrInt(String[] year1) {
        int[] yearNum;
        yearNum = new int[year1.length - 2];
        for (int k = 0; k < year1.length - 2; k++) {
            yearNum[k] = Integer.parseInt(year1[k + 2]);

        }
        return yearNum;

    }

    public static double[] stringArrDouble(String[] volume) {
        double[] volumeNum;
        volumeNum = new double[volume.length - 2];
        for (int k = 0; k < volume.length - 2; k++) {
            volumeNum[k] = Double.parseDouble(volume[k + 2]);

        }
        return volumeNum;

    }

    public static boolean compNum(double num1, double num2) {

        if ((((num2 - num1) / num1) * 100) >=6) return true;

        return false;


    }
    public static String townGet (String regionTown){
        String[] town=regionTown.split(" ");
        return town[0];
    }
//    public static void printInFile() throws IOException {
//        FileWriter writer1 = new FileWriter("src//output1.txt", false);
//        writer1.write("ugdhgfkjghkfhdkgh");
//        writer1.flush();
//    }

}


