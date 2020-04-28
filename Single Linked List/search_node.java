import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class search_node {

    Node head;

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    boolean isPresent(int s)
    {
        Node n =head;
        while(n!=null)
        {
            if(n.data==s)
                return true;
            n=n.next;
        }
        return false;

    }

    public static void main(String[] args) {
        search_node sll = new search_node();
        Scanner obj = new Scanner(System.in);
        sll.push(40);
        sll.push(30);
        sll.push(20);
        sll.push(10);

        System.out.println("Enter the value to search");
        int s=obj.nextInt();
        if(sll.isPresent(s))
            System.out.println("Yes it is present");
        else
            System.out.println("No it is not present");
    }

}