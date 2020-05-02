import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class levelOrderTraversal {
    Node root;

    void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        levelOrderTraversal tree = new levelOrderTraversal();
        tree.root = new Node(13);
        tree.root.left = new Node(12);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(19);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(9);

        System.out.println("Inorder Traversal");
        tree.inorder(tree.root);
        System.out.println("\nLevelorder Traversal");
        tree.levelorder(tree.root);
    }
}