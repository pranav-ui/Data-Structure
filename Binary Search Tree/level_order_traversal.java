import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class level_order_traversal {

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

    void levelOrder() {
        int h = height(root);
        System.out.println("height "+h);
        for (int i = 1; i <= h; i+=2) {
            printGivenLevel(root, i);
            // System.out.println();
        }
    }

    int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printGivenLevel(Node root, int level) {
        if (root == null)
            return;

        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }

    }

    public static void main(String[] args) {

        level_order_traversal tree = new level_order_traversal();
        tree.push(50);
        tree.push(30);
        tree.push(90);
        tree.push(40);
        tree.push(70);
        tree.push(60);
        tree.push(80);
        System.out.println("Level Order Traversal");
        tree.levelOrder();

    }

}