import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class leftViewRecursion {

    Node root;
    int max_level = 0;

    void leftView() {
        leftViewUtil(root, 1);
    }

    void leftViewUtil(Node node, int level) {
        if (node == null)
            return;
        if (max_level < level) {
            max_level = level;
            System.out.print(node.data + " ");
        }
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void main(String[] args) {
        leftViewRecursion bt = new leftViewRecursion();
        bt.root = new Node(10);
        bt.root.left = new Node(7);
        bt.root.right = new Node(15);
        bt.root.left.left = new Node(9);
        bt.root.right.right = new Node(11);

        bt.leftView();
    }
}