/*
Arr[(i-1) / 2]    :    Returns the parent node of node i
Arr[(2*i) + 1]    :    Returns the left child node
Arr[(2*i) + 2]    :    Returns the right child node
*/
import java.util.*;
class insertion{
    int heap[]=new int[100],heapSize=-1;
    void insert(int element)
    {
        heapSize++;
        heap[heapSize]=element;
        int now= heapSize;

        // checks whether the parent node is greter than element
        // we are using while loop bcoz we have to check whole heap 
        while(heap[(now-1)/2] > element)
        {
            // swapping between new elemnt and greatest element
            heap[now]=heap[(now-1)/2];
            now=(now-1)/2;
        }
        heap[now]=element;
    }
    public static void main(String[] args) {
        insertion hp = new insertion();
        int n;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the no. of elements in heap");
        n=obj.nextInt();
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            hp.insert(obj.nextInt());
        }
        System.out.println("elemnets in heap are:");
        for(int i=0;i<n;i++)
        {
            System.out.print(hp.heap[i]+" ");
        }

    }
}