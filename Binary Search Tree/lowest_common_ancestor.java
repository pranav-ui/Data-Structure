import java.util.*;

class Node{
    int data;
    Node left,right;

    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class lowest_common_ancestor{
    
    Node root;

    Node findancestor(Node root,int n1,int n2)
    {
        while(root!=null)
        {
            if(root.data > n1 && root.data > n2)
                root=root.left;

            else if(root.data < n1 && root.data<n2)
                root=root.right;

            else break;
        }
        return root;
    }
    public static void main(String[] args) {

        lowest_common_ancestor tree = new lowest_common_ancestor();
        tree.root=new Node(50);
        tree.root.left=new Node(30);
        tree.root.left.left=new Node(20);
        tree.root.left.right=new Node(40);
        tree.root.right=new Node(70);
        tree.root.right.left=new Node(60);
        tree.root.right.right=new Node(80);
        int n1=20,n2=40;
        Node temp= tree.findancestor(tree.root,n1,n2);
        System.out.println("Lowest common ancestor of "+n1+" and "+n2+" is "+temp.data);
    }
}