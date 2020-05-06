//  this code is still not working

import java.util.*;
class Node{
    int data;
    Node left,right;
    
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
public class cousinsOrNot {
    Node root;

    boolean isCousins(Node node,int a,int b)
    {
        return ((level(node, a, 1) == level(node, b, 1)) && 
                (!isSibling(node, a, b)));  
    }

    int level(Node root,int k,int l)
    {
        if(root==null)
            return 0;
        if(root.data==k)
            return l;
        
        int dl= level(root.left, k, l+1);
        if(dl!=0)
            return dl;
        return level(root.right, k, l+1);
    }

    boolean isSibling(Node node,int a ,int b)
    {
        if(node==null)
            return false;

        return ((node.left.data == a && node.right.data == b) || 
                (node.left.data == b && node.right.data == a) || 
                isSibling(node.left, a, b) || 
                isSibling(node.right, a, b));
    }
    public static void main(String[] args) {
        cousinsOrNot bt = new cousinsOrNot();
        Scanner obj = new Scanner(System.in);
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.left.right.right=new Node(8);
        bt.root.right.left=new Node(6);
        bt.root.right.right=new Node(7);

        System.out.println("enter the value to check whether they are cousins or not");
        int a= obj.nextInt();
        int b= obj.nextInt();

        if(bt.isCousins(bt.root,a,b))
            System.out.println("yes they are cousins");
        else
            System.out.println("No they are not cousins");
    }
}