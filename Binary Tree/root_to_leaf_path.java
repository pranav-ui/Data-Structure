import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class root_to_leaf_path {
    Node root;

    void findPath(Node root){
        int path[]= new int[100];   //initializing array as we have to store path data into array
        printPath(root,path,0);
    }

    void printPath(Node root,int path[],int index)
    {
        if(root==null)  
            return;
        
        path[index]=root.data;      //storing root data into array "path"
        index++;

         // after traversing if we reach at the leaf node then we have to print path that lead to here
        if(root.left==null && root.right ==null)    
            printArray(path,index);
        else{
            printPath(root.left, path, index);
            printPath(root.right, path, index);
        }
    }

    void printArray(int arr[],int index){
        for(int i=0;i<index;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        root_to_leaf_path bt = new root_to_leaf_path();
        bt.root = new Node(10); 
        bt.root.left = new Node(8); 
        bt.root.right = new Node(2); 
        bt.root.left.left = new Node(3); 
        bt.root.left.right = new Node(5); 
        bt.root.right.left = new Node(2); 

        bt.findPath(bt.root);
    }
}