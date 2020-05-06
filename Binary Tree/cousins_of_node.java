import java.util.*;
class  Node{
    int data;
    Node left,right;
    Node (int d)
    {
        data=d;
        left=right=null;
    }
}
public class cousins_of_node {
    Node root;

    void cousins(Node root,int k)
    {
        // getting the level of entered key
        int level = getLevel(root,k,1); 

        // printing the node on that level but it should be sibling
        printCousins(root,k,level);
    }

    //  get the level of the key entered by user
    int getLevel(Node root,int k,int level){
        if(root==null)
            return 0;
        if(root.data==k)
            return level;
        
        // if key is present in left subtree
        int downLevel=getLevel(root.left, k, level+1);

        // if we got the level return it
        if(downLevel!=0)
            return downLevel;
        
        // if key is present in right  subtree
        return getLevel(root.right, k, level+1);

    }

    void printCousins(Node root,int k,int level)
    {
        // if level is less than 2 or tree is empty
        if(root==null || level<2)
            return;

        // if current node is parent of given node with given level
        if(level==2)
        {
            if(root.left.data==k || root.right.data==k)
                return;
            if(root.left!=null)
                System.out.print(root.left.data+" ");
            if(root.right!=null)
                System.out.print(root.right.data+" ");
        }

        // recurse from left and rigt subtree   
        else if(level>2)
        {
            printCousins(root.left, k, level-1);
            printCousins(root.right, k, level-1);
        }
    }
    public static void main(String[] args) {
        cousins_of_node bt = new cousins_of_node();
        Scanner obj = new Scanner(System.in);
        bt.root=new Node(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.root.left.right.right=new Node(8);
        bt.root.right.left=new Node(6);
        bt.root.right.right=new Node(7);

        System.out.println("Enter the node of which you want to find cousins");
        int k=obj.nextInt();
        bt.cousins(bt.root,k);

    }
}