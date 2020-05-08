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
public class foldable {

    Node root;

    boolean isFoldable(Node node)
    {
        if(node==null)
            return true;
        return isFoldableUtil(node.left,node.right);
    }

    boolean isFoldableUtil(Node a,Node b)
    {
        if(a==null && b==null)
            return true;

        if(a==null || b==null)
            return false;
        
        return (isFoldableUtil(a.left, b.right) && isFoldableUtil(a.right, b.left));
    }
    public static void main(String[] args) {
        foldable bt = new foldable();
        bt.root=new Node(10);
        bt.root.left=new Node(7);
        bt.root.right=new Node(15);
        bt.root.left.left=new Node(9);
        bt.root.right.right=new Node(11);

        System.out.println(bt.isFoldable(bt.root));
    }
}