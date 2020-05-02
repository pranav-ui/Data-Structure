import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class deletion {

    Node root;

    void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    void delete(Node root,int key)
    {
        int val= cutDeepestvalue(root);
        deleteUtil(root,key,val);
    }

    void deleteUtil(Node root,int key,int val)
    {
        if(root==null)
            return;
        deleteUtil(root.left,key,val);
        if(root.data==key)
            root.data=val;
        deleteUtil(root.right, key, val);
    }

    int cutDeepestvalue(Node node) {
        int val = node.data;
        Node temp=null;
        while (node.right != null) {
            val = node.right.data;
            temp=node;
            node = node.right;
        }
        temp.right=null;
        return val;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        deletion tree = new deletion();
        tree.root=new Node(10);
        tree.root.left=new Node(11);
        tree.root.right=new Node(9);
        tree.root.left.left=new Node(7);
        tree.root.right.left=new Node(15);
        tree.root.right.right=new Node(8);
        System.out.println("Inorder traversal before deleting");
        tree.inorder(tree.root);

        System.out.println("\nenter the value to delete");
        int key=obj.nextInt();
        tree.delete(tree.root,key);
        System.out.println("Inorder traversal after deleting");
        tree.inorder(tree.root);

    }
}