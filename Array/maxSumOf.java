// Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
import java.util.*;

public class maxSumOf {

    void findSum(int arr[]) {
        int n = arr.length;
        int currentValue = 0, arrSum = 0, maxValue;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currentValue += i * arr[i];
        }
        maxValue = currentValue;
        for (int j = 1; j < n; j++) {
            currentValue += arrSum - n * (arr[n - j]);
            if (currentValue > maxValue)
                maxValue = currentValue;
        }

        System.out.println("Max Sum is "+maxValue);
    }

    public static void main(String[] args) {
        maxSumOf array = new maxSumOf();
        int arr[] = new int[] { 8, 3,1, 2 };
        array.findSum(arr);
    }
}