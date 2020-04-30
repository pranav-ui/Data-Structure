import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class construct_bst_from_levelorder {

    Node constructBst(int arr[], int n) {
        if (n == 0)
            return null;
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = levelOrder(root, arr[i]);
        }
        return root;
    }

    Node levelOrder(Node root, int d) {
        if (root == null) {
            root = new Node(d);
            return root;
        }
        if (d <= root.data)
            root.left = levelOrder(root.left, d);
        else
            root.right = levelOrder(root.right, d);

        return root;
    }

    void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {

        construct_bst_from_levelorder tree = new construct_bst_from_levelorder();

        int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        int n = arr.length;

        Node root = tree.constructBst(arr, n);

        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(root);
    }
}