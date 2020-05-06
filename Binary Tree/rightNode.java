import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
class V{
    int vLevel=0;
}

class rightNode {

    Node root;

    Node getRightNode(Node root,int k)
    {
        V v=new V();
        return getRightNodeUtil(root,k,1,v);
    }

    Node getRightNodeUtil(Node root,int k,int level,V value)
    {
        // return null if tree is empty
        if(root==null)  return null;
        // if desired node is found, set vLevel to curent level
        if(root.data == k)
        {
            value.vLevel=level;
            return null;
        }

        // if vLevel is already set , then current node is 
        // the next right node
        else if(value.vLevel!=0)
        {
            if(level==value.vLevel)
                return root;
        }

        // recurse for left subtree by incresing the level by 1
        Node leftNode = getRightNodeUtil(root.left, k, level+1, value);

        // if node is found in left subtree,return it
        if(leftNode!=null)
            return leftNode;
        
        // recurse for right subtree by increasing level by 1
        return getRightNodeUtil(root.right, k, level+1, value);
    }
    public static void main(String[] args) {
        rightNode bt = new rightNode();
        Scanner obj = new Scanner(System.in);
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.right.left=new Node(6);

        System.out.println("enter Key");
        int k = obj.nextInt();
        Node right = bt.getRightNode(bt.root,k);
        if(right!=null)
            System.out.println(right.data);
        else
            System.out.println("-1");


    }
}