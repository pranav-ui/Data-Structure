import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class rightViewRecursion {

    Node root;
    int max_level=0;
    void rightView()
    {
        rightViewUtil(root,1);
    }

    void rightViewUtil(Node node, int level)
    {
        if(node == null)
            return;
        
        if(max_level < level)
        {
            System.out.print(node.data+" ");
            max_level=level;
        }

        // traverse right subtree then left subtree
        rightViewUtil(node.right, level+1);
        rightViewUtil(node.left, level+1);
    }
    

    public static void main(String[] args) {
        rightViewRecursion bt = new rightViewRecursion();
        bt.root = new Node(10);
        bt.root.left = new Node(7);
        bt.root.right = new Node(15);
        bt.root.left.left = new Node(9);
        bt.root.right.right = new Node(11);

        bt.rightView();
    }
}