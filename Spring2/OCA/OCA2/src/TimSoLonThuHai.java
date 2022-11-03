import java.util.Arrays;

public class TimSoLonThuHai {
    public static void main(String[] args) {
        int[] array = {1,3,4,22,3,55,33,44,66,55,66,77,44,8,9};
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < array.length-1 ; i++) {
            if (array[i] > max1){
                max2 = max1;
                max1 = array[i];
            }
            if (array[i] > max2 && array[i] < max1){
                max2 = array[i];
            }
        }
            System.out.println(max2);
    }
}



//        int max1 = 0;
//        int max2 = 0;
//        for (int i = 0; i < array.length ; i++) {
//            for (int j = i+1; j <array.length-1 ; j++) {
//
//                if (array[j] > array[i] && array[j] > max1){
//                     max1 = array[j];
//                }
//                if (array[j] > array[i] && array[j] != max1){
//                    max2 = array[j];
//                }
//            }
//        }
//        System.out.println(max1);
//        System.out.println(max2);


