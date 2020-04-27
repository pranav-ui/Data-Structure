
// Insertion in Binary Search Tree
import java.util.*;

class insertion {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;

    void push(int key) {
        root = pushkey(root, key);
    }

    Node pushkey(Node root, int d) {
        if (root == null) {
            root = new Node(d);
            return root;
        }
        if (d < root.data) {
            root.left = pushkey(root.left, d);
        } else if (d > root.data) {
            root.right = pushkey(root.right, d);
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
        insertion tree = new insertion();

        tree.push(50);
        tree.push(30);
        tree.push(90);
        tree.push(40);
        tree.push(70);
        tree.push(60);
        tree.push(80);

        tree.inorder(tree.root);

    }
}