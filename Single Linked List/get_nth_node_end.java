import java.util.*;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class get_nth_node_end {

    Node head;

    void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next=head;
        head=new_node;
    }

    void getNth(int n)
    {
        Node temp = head;
        int len=0;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }

        if(n>len)
            return;
        temp=head;
        for(int i=0;i<len-n;i++)
        {
            temp=temp.next;
        }
        System.out.println("element at position " + n + " from end is "+temp.data);

    }
    public static void main(String[] args) {
        get_nth_node_end sll = new get_nth_node_end();
        sll.push(40);
        sll.push(30);
        sll.push(20);
        sll.push(10);
    
        sll.getNth(2);
    }
}