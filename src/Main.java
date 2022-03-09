import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int[] yearNum;

        Scanner scanner = new Scanner(new FileInputStream("src/table.txt"));
        int i = 0;
        while (scanner.hasNextLine()) {
            i++;
            System.out.println("I = " + i);
            if (i == 1) {
                String[] year = scanner.nextLine().split(";");
                System.out.println("Длина массива " + year.length);
                yearNum = new int[year.length];
                for (int k = 2; k < year.length; k++) {
                    yearNum[k] = Integer.parseInt(year[k]);
                    System.out.println(yearNum[k]);

                }
            } else {

                String[] productInfo = scanner.nextLine().split(";");
                System.out.println("Вывод    " + productInfo[1] + "   " + productInfo[2]);
            }
        }
    }


   public static void solution(String district, int fromYear, int toYear) {
   }

}


