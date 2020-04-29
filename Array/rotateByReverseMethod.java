import java.util.*;

public class rotateByReverseMethod {

    void rotate(int arr[],int d)
    {
        if(d==0)
            return;
        int n=arr.length;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }

    void reverse(int arr[],int start,int end)
    {
        int temp;
        while(start<end)
        {
             temp=arr[start];
             arr[start]=arr[end];
             arr[end]=temp;
             start++;
             end--;
        }
    }

    void display(int arr[])
    {
        int l=arr.length;
        for(int i=0;i<l;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        rotateByReverseMethod array = new rotateByReverseMethod();
        int arr[]=new int[]{1,2,3,4,5,6,7};
        array.rotate(arr,2);

        array.display(arr);

    }
}