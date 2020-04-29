import java.util.*;

public class countRotation {

    void count(int arr[]) {
        int n = arr.length;
        int min = arr[0];
        int min_index=0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                min_index = i;
            }
        }
        System.out.println("The array is rotated " + min_index + " times");
    }

    public static void main(String[] args) {

        countRotation array = new countRotation();
        int arr[] = new int[] { 12, 18, 2, 3, 6, 8, 10 };
        array.count(arr);
    }
}