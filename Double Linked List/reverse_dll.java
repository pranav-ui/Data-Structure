import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int d) {
        data = d;
        prev = next = null;
    }
}

public class reverse_dll {

    Node head;

    void push(int d) {
        if (head == null)
            head = new Node(d);
        else {
            Node new_node = new Node(d);
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }
    }

    void reverse() {
        Node n = head;
        Node temp = null;

        while (n != null) {
            temp = n.prev;
            n.prev = n.next;
            n.next = temp;
            n = n.prev;
        }
        if (temp != null)
            head = temp.prev;

    }

    void printdll() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        reverse_dll dll = new reverse_dll();
        dll.push(40);
        dll.push(30);
        dll.push(20);
        dll.push(10);
        dll.push(0);

        dll.reverse();
        dll.printdll();

    }
}