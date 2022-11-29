import java.util.Arrays;

public class TimSoLonThuHai {
    public static void main(String[] args) {
        int[] array = {1,2,3,6,7,8,16};
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] > max1){
                max2 = max1;
                max1 = array[i];
            }
            if (array[i] > max2 && array[i] < max1){
                array[i] = max2;
            }
        }
        System.out.println(max2);
        System.out.println(max1);


//        if (max1 % max2 ==0){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }
//        System.out.println(max1);
//        System.out.println(max2);

    }
}






