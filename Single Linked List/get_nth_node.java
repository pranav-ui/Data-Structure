import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class get_nth_node {

    Node head;

    void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next=head;
        head=new_node;
    }

    int getNth(int p)
    {
        Node n=head;
        for(int i=0;n!=null&&i<p-1;i++)
        {
            n=n.next;
        }
        return n.data;
    }
    public static void main(String[] args) {
        get_nth_node sll = new get_nth_node();
        sll.push(40);
        sll.push(30);
        sll.push(20);
        sll.push(10);

        System.out.println("Element at the position 2 "+ sll.getNth(2));
    }
}