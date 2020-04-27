import java.util.*;
class Node{
    int data;
    Node left,right;

    Node(int item)
    {
        data=item;
        left=right=null;
    }
}
public class key_sum_greaterkey 
{
    Node root;
    int sum=0;

    void addGreaterKey(Node root)
    {
        if(root==null)
            return;
        
        addGreaterKey(root.right);
        sum+=root.data;
        root.data=sum;
        addGreaterKey(root.left);
    }

    void inorder(Node node)
    {
        if(node==null)
            return ;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public static void main(String[] args) {
        key_sum_greaterkey tree = new key_sum_greaterkey();
        tree.root=new Node(5);
        tree.root.left=new Node(2);
        tree.root.right=new Node(13);

        System.out.println("inorder traversal of BST before the operatoin");
        tree.inorder(tree.root);
        tree.addGreaterKey(tree.root);
        System.out.println("\ninorder traversal of BST after the operation");
        tree.inorder(tree.root);
    }
}