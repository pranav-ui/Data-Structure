import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class min_value {

    Node root;

    void insert(int data) {
        root = insertKey(root, data);
    }

    Node insertKey(Node root, int d) {
        if (root == null) {
            root = new Node(d);
            return root;
        }

        if (d < root.data)
            root.left = insertKey(root.left, d);

        else if (d > root.data)
            root.right = insertKey(root.right, d);

        return root;
    }

    int minValue(Node root) {
        int min = root.data;

        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {

        min_value tree = new min_value();

        tree.insert(50);
        tree.insert(40);
        tree.insert(20);
        tree.insert(45);
        tree.insert(60);
        tree.insert(55);
        tree.insert(75);

        int min = tree.minValue(tree.root);

        System.out.println("min value in bst is " + min);
    }
}