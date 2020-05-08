import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class identical {

    Node root1,root2;

    boolean isIdentical(Node node1,Node node2)
    {
        if(node1==null && node2==null)
            return true;

        if(node1!=null && node2!=null)
            return (node1.data == node2.data && isIdentical(node1.left, node2.left)
                    && isIdentical(node1.right, node2.right));

        return false;
    }
    public static void main(String[] args) {
        identical bt = new identical();

        bt.root1=new Node(10);
        bt.root1.left=new Node(7);
        bt.root1.right=new Node(15);
        bt.root1.left.left=new Node(9);
        bt.root1.right.right=new Node(11);

        bt.root2=new Node(10);
        bt.root2.left=new Node(7);
        bt.root2.right=new Node(15);
        bt.root2.left.left=new Node(10);
        bt.root2.right.right=new Node(11);

        if(bt.isIdentical(bt.root1,bt.root2))
            System.out.println("YES, the trees are identical");
        else
            System.out.println("NO,trees are not identical");
    }
}