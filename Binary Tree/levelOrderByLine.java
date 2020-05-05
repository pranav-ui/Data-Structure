import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class levelOrderByLine {
    Node root;

    void levelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int count_node;
        while(true)
        {
            count_node=q.size();
            if(count_node==0)
                break;

            while(count_node>0)
            {
                Node temp=q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                count_node--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        levelOrderByLine bt = new levelOrderByLine();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);

        bt.levelOrder(bt.root);
    }
}