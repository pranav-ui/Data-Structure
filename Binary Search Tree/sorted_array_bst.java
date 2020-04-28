import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class sorted_array_bst {
    void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    Node constructbst(int arr[], int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = constructbst(arr, start, mid - 1);

        root.right = constructbst(arr, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        sorted_array_bst tree = new sorted_array_bst();
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int len = arr.length;
        Node root = tree.constructbst(arr, 0, len - 1);
        tree.preorder(root);

    }
}