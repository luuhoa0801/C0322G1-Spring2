import java.awt.*;
import java.util.*;
import java.util.List;

public class test {
    //    public static void main(String[] args) {
//        int aVar = 1;
//        if (aVar++ < 10) {
//            System.out.println(aVar + " Hello World!");
//        } else {
//            System.out.println(aVar + " Hello Universe!");
//        }
//    }
//    public static void main(String[] args) {
//        Short s1 = 200;
//        Integer s2 = 400;
//        Long s3 = (long) s1 + s2;
//        String s4 = (String) (s3 * s2);
//        System.out.println("Sum is " + s4);
//    }

//    public static void main(String[] args) {
//        String[] a = {"a", "b", "a", "c", "b"};
//        int count = 0;
//        String[] b = new String[10];
//        for (int i = 0; i < a.length; i++) {
//
//        }
//        for (int j = 0; j < b.length; j++) {
//
//        }
//    }

    //Đảo ngược các phần tử của 1 số nhập vào
//    public static void main(String[] args) {
////sử dụng class Scanner để lấy dữ liệu từ bàn phím
//        Scanner sc = new Scanner(System.in);
//        //khai báo biến num1 là số cần đảo ngược, reversed là số sau khi đảo ngược
//        int num1, num2, reversed = 0;
//        System.out.println("\n\nNhập vào số cần đảo ngược: ");
//        num1 = sc.nextInt();
//        //sở dĩ mình gán num1 cho num2 chỉ để hiển thị ra màn hình
//        num2 = num1;
//        //sử dụng vòng lặp while để đảo ngược num1
//        while (num1 != 0) {
//            int digit = num1 % 10;
//            reversed = reversed * 10 + digit;
//            num1 /= 10;
//        }
//        //hiển thị số sau khi đảo ngược ra màn hình
//        System.out.printf("Số %d sau khi đảo ngược là: %d", num2, reversed);
//    }

    public static void main(String[] args) {
        int[] array = {1,3,4,22,3,55,33,8,9};
            Arrays.sort(array);
//        for (int item :array) {
//            System.out.println(item);
//        }

        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
//        for (int i = 0; i <array.length ; i++) {
//            System.out.println(array[i]);
//        }
        System.out.println("Số lớn thứ 2 là " + (array[array.length-2]) );
    }

    //    public static void main(String args[]) {
//        String s1 = "Hello";
//        String s2 = "HELLO";
//        String s3 = "He";
//        System.out.println(s1.contains(s3));
//    }
//    public static void main(String[] args) {
//     String a = "a";
//     String b = "b";
//     String c = "c";
//     String d = "hello" + "CodeGym" + "2022";
//        System.out.println(a + b + c);
//        System.out.println(d);
//    }


    //    public static void main(String[] args) {
//        //đảo ngược các phần tử trong chuỗi
//        String a = "aloxinh";
//        StringBuffer stringBuffer = new StringBuffer(a);
//        System.out.println(stringBuffer.reverse().toString());
//
//    }
//    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        System.out.println(a);
//        List<Integer> b = new ArrayList<>();
//        b.add(1);
//        b.add(1);
//        b.add(1);
//        b.add(1);
//        b.add(1);
//        b.add(1);
//        b.add(2);
//        b.add(3);
//        b.add(5);
//        b.add(7);
//        b.add(5);
//        System.out.println(b);
//        List<Integer> c = new ArrayList<>();
//        int cout = 0;
//        for (Integer item : b) {
//            if (a.contains(item)) {
//                if (!c.contains(item)) {
//                    c.add(item);
//                }
//            }
//        }
//        System.out.println(c);

//            System.out.printf("%03d\n",5);
//            String str = String.format("%03d\n",5);
//    }


//    public static void main(String[] args) {
//        int[] arr1 = {6, 3, 2, 5, 7, 2, 1, 1,6,7};
//        solution(arr1);
//    }
//
//    static void solution(int[] arr1) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr1.length ; i++) {
//            set.add(arr1[i]);
//        }
//        System.out.println(set);
//    }
//public static void main(String[] args) {
//    int a = 4;
//    int b = 7;
//    a = a+b;
//    b = a - b ;
//    a = a-b;
//    System.out.println(a);
//    System.out.println(b);
//
//}


}

