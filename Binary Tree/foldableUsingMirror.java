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
public class foldableUsingMirror {

    boolean isFoldable(Node node)
    {
        boolean res;

        if(node == null)
            return true;
        
        mirror(node.left);

        res= isStruct(node.left,node.right);

        mirror(node.left);

        return res;
    }

    void mirror(Node node)
    {
        if(node==null)
            return;

        Node temp;
        mirror(node.left);
        mirror(node.right);

        temp=node.left;
        node.left=node.right;
        node.right=temp;
    }

    boolean isStruct(Node a, Node b)
    {
        if(a==null && b==null)
            return true;
        if((a!=null &&  b!=null) && isStruct(a.left, b.left) && isStruct(a.right, b.right))
            return true;

        return false;
    }

    Node root;
    public static void main(String[] args) {
        foldableUsingMirror bt = new foldableUsingMirror();
        bt.root=new Node(10);
        bt.root.left=new Node(7);
        bt.root.right=new Node(15);
        bt.root.left.left=new Node(9);
        bt.root.right.right=new Node(11);

        System.out.println(bt.isFoldable(bt.root));
    }
}