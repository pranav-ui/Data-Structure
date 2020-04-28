// program to tranform a binary serch tree to a grreater sum tree

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class bst_greater_sum_tree {
    int sum = 0;

    void findsum(Node root) {
        if (root == null)
            return;

        findsum(root.left);
        sum += root.data;
        findsum(root.right);

    }

    void transform(Node root) {
        if (root == null)
            return;

        transform(root.left);
        sum -= root.data;
        root.data = sum;
        transform(root.right);

    }

    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        bst_greater_sum_tree tree = new bst_greater_sum_tree();
        Node root;
        root = new Node(11);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right = new Node(29);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);
        System.out.println("Inorder Traversal of tree Before the Greater Sum Tree");
        tree.inorder(root);

        tree.findsum(root);
        System.out.println("\nInorder Traversal of tree After the Greater Sum Tree");

        tree.transform(root);
        tree.inorder(root);

    }
}