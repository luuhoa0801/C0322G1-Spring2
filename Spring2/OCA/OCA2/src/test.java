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


    //Kiểm tra mảng đối xứng
//    public static void main(String[] args) {
//        int[] a={3,2,1,6,5,7,6,1,2,3};
//        int kt =1;
//        int sum = 0;
//        for (int i = 0; i < (a.length)/2; i++) {
//            if (a[i] != a[a.length -i -1]){
//                kt = 0;
//                break;
//            }
//            sum++;
//        }
//        if (kt == 0){
//            System.out.println("Mảng k đối xứng");
//        }else {
//            System.out.println("mảng đối xứng");
//        }
//        System.out.println(sum);
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


//    public static void main(String[] args) {
//        int[] array = {1,3,4,22,3,55,33,8,9};
//            Arrays.sort(array);
////        for (int item :array) {
////            System.out.println(item);
////        }
//
//        for (int i = 0; i <array.length-1 ; i++) {
//            for (int j = i+1; j <array.length ; j++) {
//                if (array[i] > array[j]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
////        for (int i = 0; i <array.length ; i++) {
////            System.out.println(array[i]);
////        }
//        System.out.println("Số lớn thứ 2 là " + (array[array.length-2]) );
//    }


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

//        //đảo ngược các phần tử trong chuỗi
    //    public static void main(String[] args) {
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

    // đảo ngược các phần tử ko sử dụng biến tạm
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


    //loại bỏ phần tử trùng lặp




//public static void main(String[] args) {
//            int[] arr = {6, 3, 2, 5, 7, 2, 1, 1,6,7};
//            int size = arr.length;
//    for (int i = 0; i < size-1 ; i++) {
//        for (int j = i+1; j < size ; j++) {
//            if (arr[i] == arr[j]){
//                for (int k = j; k < size -1 ; k++) {
//                    arr[k] = arr[k+1];
//                }
//                arr[size-1] =0;
//                size--;
//            }
//        }
//    }
//    System.out.println(Arrays.toString(arr));
//}

    // lấy các giá trị không trùng lặp
//    public static void main(String[] args) {
//        int arr[] = {1, 3, 3, 4,4, 5, 9, 6, 3};
//        Arrays.sort(arr);
//        int j = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] != arr[i + 1]) {
//                arr[j] = arr[i];
//                j++;
//            }
//        }
//        arr[j] = arr[arr.length - 1];
//        for (int i = 0; i <= j; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }

    //OCA9
//    public static void main(String[] args) {
//        String opt = true;
//        switch (opt){
//            case true:
//                System.out.println("True");
//                break;
//            default:
//                System.out.println("***");
//        }
//        System.out.println("Done");
//    }

//    public static void main(String[] args) {
//        int x = 100;
//        int a = x++;
//        int b = ++x;
//        int c = x++;
//        int f = ++x;
//        int d = (a < b) ? (a < c) ? a : (b < c) ? b : c;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(f);
//    }

    //OCA10
//    public static void main(String[] args) {
//        String[] [] chs = new String[2][];
//        chs[0] = new String[2];
//        chs[1] = new String[5];
//        int i = 97;
//        for (int a = 0; a < chs.length ; a++) {
//            for (int b = 0; b < chs.length; b++) {
//                chs[a][b] = "" + i;
//                i++;
//            }
//        }
//        for (String[] ca:chs) {
//            for (String c: ca) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[] args) {
//        int n = 21;
//        int sum =0;
//        int kt = 0;
//        for (int i = 1; i < n ; i++) {
//            if (i % 5 ==0){
//                sum += i;
//                kt ++ ;
//                System.out.println(i);
//            }
//            if (kt ==2){
//                break;
//            }
//        }
//        System.out.println(sum);


//        int[] arr = {1,2,3,4,5,4,3,2,1};
//        int kt = 1;
//        for(int i = 0;i<arr.length/2;i++){
//            if(arr[i] != arr[arr.length-1-i]){
//                kt = 0;
//                break;
//            }
//        }
//        if(kt == 0){
//            System.out.println("Mảng k đối xứng");
//        }else{
//            System.out.println("Mảng đối xứng");
//        }


    }


}

