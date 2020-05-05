import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class btFromAray {
    Node root;

    Node insert(Node root, int arr[]) {
        root = insertUtil(arr, root, 0);
        return root;
    }

    Node insertUtil(int arr[], Node root, int i) {
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            root.left = insertUtil(arr, root.left, 2 * i + 1);

            root.right = insertUtil(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        btFromAray bt = new btFromAray();
        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        Node root = bt.insert(bt.root, arr);
        bt.inorder(root);
    }
}