import java.util.*;
public class maxHeapOrNot {
    static int isMaxHeap(int array[], int n) {
        int k = 0;
        if (n == 1)
            return 1;
        if (n < 4)
            k = n;
        else
            k = (n - 2) / 2;
        for (int i = 0; i < k; i++) {
            int res = check(array, i, n);
            if (res == 0)
                return 0;
        }
        return 1;
    }

    static int check(int array[], int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // if(l<n && r<n && array[i]>array[l] && array[i]>array[r])
        // return 1;
        // else
        // return 0;
        if (r < n) {
            if (array[i] > array[l] && array[i] > array[r])
                return 1;
            else
                return 0;
        }
        if (l < n) {
            if (array[i] > array[l])
                return 1;
            else
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        int t, n, i, k;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while (t != 0) {
            n = s.nextInt();
            int[] a = new int[n];
            for (i = 0; i < n; i++)
                a[i] = s.nextInt();
            System.out.println(isMaxHeap(a, n));
            t--;
        }
    }
}
