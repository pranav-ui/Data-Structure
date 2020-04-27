
// Construct BST from given preorder traversal
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class construct_bst_from_preorder {

    Node root;

    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void insert(int key) {
        root = insertkey(root, key);
    }

    Node insertkey(Node root, int d) {
        if (root == null) {
            root = new Node(d);
            return root;
        }

        if (d < root.data)
            root.left = insertkey(root.left, d);
        else if (d > root.data)
            root.right = insertkey(root.right, d);

        return root;
    }

    public static void main(String[] args) {
        construct_bst_from_preorder tree = new construct_bst_from_preorder();
        int arr[] = new int[] { 10, 5, 1, 7, 40, 50 };
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            tree.insert(arr[i]);
        }
        tree.inorder(tree.root);
    }
}