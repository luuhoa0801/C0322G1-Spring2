import java.util.Arrays;

public class QuickSort {
    public static int partition(int arr[], int begin,int end){
        int cuoi = arr[end];
        int i = (begin -1);
        for (int j = begin; j <end ; j++) {
            if (arr[j] <= cuoi){
                i++;
                int swaTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swaTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i +1;
    }
    public static void quickSort(int arr[], int begin, int end){
        if (begin < end){
            int partition = partition(arr,begin,end);
            quickSort(arr,begin,partition - 1);
            quickSort(arr,partition + 1,end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,4,6,3,8,5,24,9};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));    }
}
