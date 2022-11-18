import java.util.Arrays;

public class LoaiTrungLap {
    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 5, 7, 2, 1, 1,6,7};
        int size = arr.length;
        for (int i = 0; i < size-1 ; i++) {
            for (int j = i+1; j < size ; j++) {
                if (arr[i] == arr[j]){
                    for (int k = j; k < size -1 ; k++) {
                        arr[k] = arr[k+1];
                    }
                    arr[size-1] =0;
                    size--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
