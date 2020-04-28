import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class insertion_and_deletion {

    Node head;

    void push(int new_data) {
        // making node to be inserted in linkedlist
        Node new_node = new Node(new_data);
        // storing the address of head in the next of new_node
        new_node.next = head;
        // then making the new_node a head of linkedlist
        head = new_node;
    }

    void insertafter(int index, int new_data, int count) {
        // if(index is 1 i.e insertion at first)
        if (index == 1) {
            push(new_data);
        }
        // if the index is greater the the size of linkedlist
        else if (index > count + 1) {
            System.out.println("Wrong index entered");
        } else {
            Node new_node = new Node(new_data);
            Node iterate = head;
            // System.out.println(iterate.data);
            for (int i = 1; i < index - 1; i++) {
                iterate = iterate.next;
            }
            new_node.next = iterate.next;
            iterate.next = new_node;
        }
    }

    void insertend(int new_data) {

        Node new_node = new Node(new_data);
        Node n = head;
        // if linked list is empty it will insert at head
        if (head == null) {
            head = new_node;
            return;
        } else {
            while (n.next != null) { // it will iterate untill last node comes out
                n = n.next;
            }
            n.next = new_node;
        }

    }

    void deletefirst() {
        head = head.next;
    }

    void deleteend() {
        Node n = head;
        while (n.next.next != null) {
            n = n.next;
        }
        n.next = null;
    }

    void deletenode(int v) {
        Node n = head, prev = null;
        // if the value to be deleted is the first node
        if (n != null && n.data == v) {
            head = n.next;
        }
        while (n != null && n.data != v) {
            prev = n;
            n = n.next;
        }
        if (n == null) // if we didnt get that particular value
            return;

        prev.next = n.next;

    }

    void deleteposition(int p) {
        Node n=head;
        if(n==null)
            return;
        
        if(p==0)
        {
            head=head.next;
            return;
        }
        for(int i=0;n!=null && i<p-1;i++)
        {
            n=n.next;
        }
        Node temp=n.next;
        n.next=temp.next;
    }
        

    void display() {
        Node n = head;
        System.out.println("Created linked list are: ");
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int p, v, option, d, index, count = 0;
        insertion_and_deletion list = new insertion_and_deletion();
        do {
            System.out.println("\noptions are:");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert after a given node");
            System.out.println("3. insert at end");
            System.out.println("4. delete first node");
            System.out.println("5. delete last node");
            System.out.println("6. delete a particular node");
            System.out.println("7. delete at particular position");
            System.out.println("Enter a option");

            option = obj.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Enter the value to be inserted");
                    d = obj.nextInt();
                    list.push(d);
                    list.display();
                    count++;
                    break;
                }
                case 2: {
                    System.out.println("Enter the value to be inserted");
                    d = obj.nextInt();
                    System.out.println("Enter the index at which you have to insert the node");
                    index = obj.nextInt();
                    list.insertafter(index, d, count);
                    list.display();
                    count++;
                    break;
                }
                case 3: {
                    System.out.println("Enter the value to be inserted");
                    d = obj.nextInt();
                    list.insertend(d);
                    list.display();
                    count++;
                    break;
                }
                case 4: {
                    list.deletefirst();
                    list.display();
                    break;
                }
                case 5: {
                    list.deleteend();
                    list.display();
                    break;
                }
                case 6: {
                    System.out.println("enter the value to be deleted");
                    v = obj.nextInt();
                    list.deletenode(v);
                    list.display();
                    break;
                }
                case 7: {
                    System.out.println("enter the position to delete the node at");
                    p = obj.nextInt();
                    list.deleteposition(p);
                    list.display();
                    break;
                }
                default: {
                    System.out.println("wrong choice");
                    break;
                }
            }
        } while (option != 0);

    }
}