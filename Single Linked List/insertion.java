import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class insertion {

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
        int option, d, index, count = 0;
        insertion list = new insertion();
        do {
            System.out.println("\noptions are:");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert after a given node");
            System.out.println("3. insert at end");
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
                default: {
                    System.out.println("wrong choice");
                    break;
                }
            }
        } while (option != 0);

    }
}