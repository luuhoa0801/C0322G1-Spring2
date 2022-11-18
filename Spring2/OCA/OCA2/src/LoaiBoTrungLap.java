import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LoaiBoTrungLap {
    public static void main(String[] args) {
        Integer arr[] = {1, 3, 3, 4, 5,5, 9, 6,6, 3};
        Set<Integer> arr1 = new LinkedHashSet<>();
        for (int i = 0; i < arr.length ; i++) {
            arr1.add(arr[i]);
        }
        Integer[] arr2 =
                Arrays.copyOf(arr1.toArray(), arr1.size(), Integer[].class);

        for (int i = 0; i <arr.length ; i++) {
            if (i < arr2.length){
                arr[i] = arr2[i];
            }else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
