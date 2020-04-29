// This code has both the methods ,one with comments and one is implemented in this.
// first method is in comments which has time complexity of O(n*d)

//second method has time complexity of O(n)
import java.util.*;

class array_rotation {
    /*
     * void rotate(int arr[], int d, int n) { for (int i = 0; i < d; i++)
     * rotatebyone(arr, n); }
     * 
     * void rotatebyone(int arr[],int n) { int i,temp=arr[0]; for(i=0;i<n-1;i++) {
     * arr[i]=arr[i+1]; } arr[i]=temp; }
     */

    void rotate(int arr[], int d, int n) {
        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < n - d; i++) {
            arr[i] = arr[i + d];
        }
        for (int i = n - d; i < n; i++) {
            arr[i] = temp[i - (n - d)];
        }
    }

    void display(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        array_rotation array = new array_rotation();
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        array.rotate(arr,2,7);
        array.display(arr, 7);

    }
}