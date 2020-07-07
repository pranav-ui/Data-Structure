import java.util.*;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class detectLoop {

    Node head;

    public void push(int d) {
        Node new_node = new Node(d);
        new_node.next = head;
        head = new_node;

    }

    boolean isDetectLoop(Node h) {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
            if (s.contains(h))
                return true;

            s.add(head);
            h = h.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        detectLoop sll = new detectLoop();
        int n = 5;
        while (n > 0) {
            sll.push(obj.nextInt());
            n--;
        }
        // sll.head.next.next.next.next.next = sll.head;
        if (sll.isDetectLoop(sll.head))
            System.out.println("True");
        else
            System.out.println("False");
    }
}