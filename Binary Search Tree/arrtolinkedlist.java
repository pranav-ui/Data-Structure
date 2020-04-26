class arrtolinkedlist {
    Node head;
    class Node
    {
            int data;
            Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void push(int new_data)
    {
        Node new_node= new Node(new_data);
        new_node.next=head;
        head=new_node;
    }

    public void display(){
        Node n= head;
        while(n!=null)
        {
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
    public static void main(String[] args) {
        int n;
        arrtolinkedlist list = new arrtolinkedlist();
        int arr[]={1,2,3,4,5};
        n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            list.push(arr[i]);
        }
        list.display();
    }
}