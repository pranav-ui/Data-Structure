import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class kthSmallestElement {
    Node root;
    int count = 0;

    Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    void printKthSmallest(Node root, int k) {

        if (root == null)
            return;
        printKthSmallest(root.left, k);
        count++;
        if (count == k)
            System.out.println(root.data);
        printKthSmallest(root.right, k);
    }

    public static void main(String[] args) {

        kthSmallestElement tree = new kthSmallestElement();
        Node root = null;
        int keys[] = { 4,2,7,1,3,5,8};

        for (int x : keys)
            root = tree.insert(root, x);

        int k = 1;
        tree.printKthSmallest(root, k);
    }
}