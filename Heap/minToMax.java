import java.util.*;

public class minToMax {
    static void modifyMintoMax(int array[], int n) {
        for (int i = (n - 2) / 2; i >= 0; --i)
            maxHeap(array, i, n);
    }

    static void maxHeap(int array[], int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n && array[l] > array[i])
            largest = l;
        if (r < n && array[r] > array[largest])
            largest = r;
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest, n);
        }
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
            modifyMintoMax(a, n);
            for (i = 0; i < n; i++)
                System.out.print(a[i] + " ");
            System.out.println();
            t--;
        }
    }
}
