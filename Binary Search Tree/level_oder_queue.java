import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class level_oder_queue {

    Node root;

    void levelorder() {
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

        level_oder_queue tree = new level_oder_queue();

        tree.root = new Node(50);
        tree.root.left = new Node(20);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);
        System.out.println("level order traversal using queue of Binary search tree");
        tree.levelorder();
    }
}