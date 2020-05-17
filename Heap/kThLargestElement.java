import java.util.*;

public class kThLargestElement {
    static void printKLargest(int array[], int n, int k) {
        int l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] < array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        for (l = 0; l < k - 1; l++) {
            System.out.print(array[l] + " ");
        }
        System.out.print(array[l]);
    }

    public static void main(String[] args) {
        int t, n, i, k;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while (t != 0) {
            n = s.nextInt();
            int[] a = new int[n];
            k = s.nextInt();
            for (i = 0; i < n; i++)
                a[i] = s.nextInt();
            printKLargest(a, n, k);
            System.out.println();
            t--;
        }
    }
}