import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int[] arrYear = new int[6];
        Scanner scanner = new Scanner(new FileInputStream("src/table.txt"));
        int i = 0;
        while (scanner.hasNextLine()) {
            i++;
            if (i == 1) {
                String[] year = scanner.nextLine().split(";");

                for (int s : stringArrInt(year)) System.out.println(s);
                //arrYear = new int[stringArrInt(year).length];
                arrYear = stringArrInt(year);
                System.out.println("Массив года ");


            } else {
                String[] volumeInfo = scanner.nextLine().split(";");
                for (double s : stringArrDouble(volumeInfo)) System.out.println(s);
                System.out.println("Массив урожая ");
                double[] arrVolume = stringArrDouble(volumeInfo);
                for (int f = 0; f < arrVolume.length - 1; f++) {
                    //     System.out.println("Вход в цикл");
                    if (compNum(arrVolume[f], arrVolume[f + 1])) {
                        System.out.println("Part ;" + arrYear[f] + ";" + arrYear[f + 1]);
                        System.out.println("Регион ;" + +arrVolume[f] + " ; " + arrVolume[f + 1]);
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

        if ((((num2 - num1) / num1) * 100) >= 7) return true;

        return false;


    }
}


