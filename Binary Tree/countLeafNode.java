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
public class countLeafNode {

    Node root;

    int count(Node root)
    {
        if(root==null)  return 0;
        if(root.left==null && root.right==null)
            return 1;
        else
            return count(root.left)+count(root.right);
    }
    public static void main(String[] args) {
        countLeafNode bt = new countLeafNode();
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right= new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        int c = bt.count(bt.root);
        System.out.println("No. of Leaf Node :" + c);

    }
}