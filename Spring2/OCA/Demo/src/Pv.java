public class Pv {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5,3,4,4,6,7};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
        int max1 = arr[0];
        int max2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;
                max1 =arr[i];
            }
        }
        return max2;
    }
}
