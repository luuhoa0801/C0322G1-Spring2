public class demoSoThu2 {
    public static void main(String[] args) {
        int max = 0;
        int max2 = 0;
        int[] arr = {1,3,4,5,5,4,33,33,44,44,22,22,2};
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i] > max) {
                max2 = max;
                max = arr[i];
            }
            if (arr[i] > max2 && arr[i] < max) {
                max2 = arr[i];
            }

        }
        System.out.println(" max = " + max + "------" + " max2 = " + max2);

    }

    }

