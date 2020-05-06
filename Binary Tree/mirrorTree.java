import java.util.*;
class Node{
    int data;
    Node left,right;

    Node(int d){
        data=d;
        left=right=null;
    }
}
public class mirrorTree {
    Node root;

    Node mirror(Node root)
    {
        if(root==null)
            return null;

        // recurse the tree.
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        // swapping the node
        root.left=right;
        root.right=left;

        return root;
    }

    void inorder(Node root)
    {
        if(root==null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        mirrorTree bt = new mirrorTree();
        bt.root= new Node(1);
        bt.root.left= new Node(2);
        bt.root.right= new Node(3);
        bt.root.left.left= new Node(4);
        bt.root.left.right= new Node(5);
        System.out.println("Inorder traversal of root");
        bt.inorder(bt.root);
        bt.root= bt.mirror(bt.root);
        System.out.println("\nInorder traversal of mirror tree");
        bt.inorder(bt.root);
       
    }
}