import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class bstOrNot {

    Node root;

    boolean isBst(Node root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBstUtil(Node root, int min, int max) {

        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;
        return (isBstUtil(root.left, min, root.data - 1) && isBstUtil(root.right, root.data + 1, max));
    }

    public static void main(String[] args) {
        bstOrNot tree = new bstOrNot();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        if (tree.isBst(tree.root))
            System.out.println("Yes it is a Binary Search Tree");
        else
            System.out.println("No it is not a Binary Search Tree");

    }
}