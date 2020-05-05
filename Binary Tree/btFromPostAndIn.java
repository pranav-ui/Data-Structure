import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Index { 
    int index; 
} 

class btFromPostAndIn {

    // Node root;

    Node buildTree(int in[],int post[],int n)
    {
        Index pIndex = new Index();
        pIndex.index=n-1;
        return buildTreeUtil(in,post,0,n-1,pIndex);

    }

    Node buildTreeUtil(int in[],int post[],int inStart,int inEnd,Index pIndex)
    {
        if(inStart > inEnd)
            return null;

        Node node = new Node(post[pIndex.index]);
        (pIndex.index)--;

        if(inStart==inEnd)
            return node;
        
        int sIndex= searchIndex(in,inStart,inEnd,node.data);

        
        node.right=buildTreeUtil(in, post, sIndex+1, inEnd, pIndex);
        node.left=buildTreeUtil(in, post, inStart, sIndex-1, pIndex);
        

        return node;
    }

    int searchIndex(int arr[],int start,int end,int value)
    {
        int i;
        for(i=start;i<=end;i++)
        {
            if(arr[i]==value)
            break;
        }
        return i;
    }

    void preOrder(Node root){
        if(root==null)
            return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        btFromPostAndIn bt = new btFromPostAndIn();
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        Node root = bt.buildTree(in, post, n);
        System.out.println("PreOrder of constructed Binary tree");
        bt.preOrder(root);
    }
}