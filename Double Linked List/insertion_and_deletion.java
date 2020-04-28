import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

class insertion_and_deletion {

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

    void append(int d) {
        Node n = head;
        if (n == null) {
            head = new Node(d);
            return;
        }
        while (n.next != null) {
            n = n.next;
        }
        Node new_node = new Node(d);
        n.next = new_node;
        new_node.prev = n.next;
    }

    void insertat(int d,int index)
    {
        Node n= head;

        if(index==0){
            push(d);
            return;
        }
        for(int i=0 ; i<index-1 && n!=null ; i++)
        {
            n=n.next;
        }
        Node new_node = new Node(d);
        
        new_node.next=n.next;
        n.next=new_node;
    }

    void deletefirst()
    {
        head=head.next;
        head.prev=null;        
    }

    void deleteend()
    {
        Node n =head;
        while(n.next.next!=null)
        {
            n=n.next;
        }
        n.next=null;
    }

    void deleteat(int p)
    {
        Node n=head;
        Node temp=null;
        if(p==0)
        {
            deletefirst();
            return;
        }
        for(int i=0 ; n!=null && i< p ; i++)
        {
            temp=n;
            n=n.next;
        }
        temp.next=n.next;
        n=n.next;
        n.prev=temp;

    }

    void display() {
        System.out.println("forward traversal of DLL");
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        insertion_and_deletion dll = new insertion_and_deletion();
        int options, d,index;
        do {
            System.out.println();
            System.out.println("\n1. insert at front in DLL");
            System.out.println("2. insert at end in DLL");
            System.out.println("3. insert after particular index in DLL");
            System.out.println("4. delete first node");
            System.out.println("5. delete last node");
            System.out.println("6. delete particular node");
            System.out.println("0. exit");
            System.out.println("Enter the options");
            options = obj.nextInt();
            switch (options) {
                case 0:{
                    break;
                }
                case 1: {
                    System.out.println("enter the value to be inserted at front of DLL");
                    d = obj.nextInt();
                    dll.push(d);
                    dll.display();
                    break;
                }
                case 2: {
                    System.out.println("Enter the value to be inserted at end in DLL");
                    d = obj.nextInt();
                    dll.append(d);
                    dll.display();
                    break;
                }
                case 3:{
                    System.out.println("Enter the value to be inserted at end in DLL");
                    d=obj.nextInt();
                    System.out.println("Enter the index at which you like to add the value");
                    index=obj.nextInt();
                    dll.insertat(d, index);
                    dll.display();
                    break;
                }
                case 4:{
                    dll.deletefirst();
                    System.out.println("First node deleted");
                    dll.display();
                    break;
                }
                case 5:{
                    dll.deleteend();
                    System.out.println("Last node deleted");
                    dll.display();
                    break;
                }
                case 6:{
                    System.out.println("Enter the position at which node will be deleted");
                    index=obj.nextInt();
                    dll.deleteat(index);
                    System.out.println("Node deleted at given position");
                    dll.display();
                    break;
                }
                default:
                System.out.println("wrong choice");
            }
        } while (options != 0);

    }
}