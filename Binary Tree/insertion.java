import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class insertion{

    Node root;

    void insert(Node temp,int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        while(!q.isEmpty())
        {
            temp=q.peek();
            q.remove();

            if(temp.left==null){
                temp.left=new Node(key);
                break;
            }
            else q.add(temp.left);

            if(temp.right==null){
                temp.right=new Node(key);
                break;
            }
            else q.add(temp.right);
        }
    }

    void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        insertion tree = new insertion();
        tree.root=new Node(10);
        tree.root.left=new Node(11);
        tree.root.right=new Node(9);
        tree.root.left.left=new Node(7);
        tree.root.right.left=new Node(15);
        tree.root.right.right=new Node(8);

        System.out.println("Inorder Traversal of Binary Tree Before Insertion : ");
        tree.inorder(tree.root);
        tree.insert(tree.root,12);
        System.out.println("\nInorder Traversal of Binary Tree After Insertion : ");
        tree.inorder(tree.root);

    }
}