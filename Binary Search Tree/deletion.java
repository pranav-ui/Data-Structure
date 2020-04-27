
// Deletion in Binary Search Tree
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class deletion {
    Node root;

    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void deletekey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minvalue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minvalue(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    public static void main(String[] args) {
        deletion tree = new deletion();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.left.left = new Node(20);
        tree.root.right = new Node(70);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        System.out.println("Inorder traversal of BST \nbefore Deletion");
        tree.inorder(tree.root);

        tree.deletekey(50);
        System.out.println("\nInorder traversal of BST \nafter Deletion");
        tree.inorder(tree.root);

    }

}