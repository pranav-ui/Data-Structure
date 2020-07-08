import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d)
    {
        data=d;
        next=null;
    }
}
public class pallindrome
{

    Node head;

    void push(int d)
    {
        Node new_node = new Node(d);
        new_node.next=head;
        head = new_node;
    }

    boolean isPallindrome(Node head)
    {
        Node q;
        q=head;
        Stack<Integer> s = new Stack<Integer>();
        while(q!=null)
        {
            s.push(q.data);
            q=q.next;
        }
        q=head;
        while(q!=null)
        {
            if(s.pop()!=q.data)
                return false;
            q=q.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        pallindrome sll = new pallindrome();
        int n;
        n=obj.nextInt();
        while(n>0)
        {
            sll.push(obj.nextInt());
            n--;
        }
        if(sll.isPallindrome(sll.head))
            System.out.println("Pallindrome");
        else
            System.out.println("Not Pallindrome");
    }
}