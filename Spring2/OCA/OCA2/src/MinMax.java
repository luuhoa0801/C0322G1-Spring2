import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Random rd = new Random();
        System.out.println("Nhập số phần tử của Mảng: ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> array = new ArrayList<>();
        int iNew = 0;
        for (int i = 0; i < n; i++) {
            iNew = rd.nextInt(100);
            array.add(iNew);
        }
        int max = array.get(0);
        int min = array.get(0);
        // random 10 number between 100
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        System.out.println(array);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);


        // random new item difference from previous random item
//        int iNewNumber = 0, iPrevious = -1;
//        for (int i = 0; i < n; ) {
//            iNewNumber = rd.nextInt(100);
//            if (iNewNumber != iPrevious) {
//                i++;
//                iPrevious = iNewNumber;
//                System.out.println("Item " + (i) + ":" + iNewNumber);
//            }
//        }

        // random unique number
//        ArrayList<Integer> v = new ArrayList<>();
//        int iNew = 0;
//        for (int i = 0; i < n; ) {
//            iNew = rd.nextInt(100);
//            if (!v.contains(iNew)) {
//                i++;
//                v.add(iNew);
//            }
//        }
//        System.out.println(v);
    }
}
