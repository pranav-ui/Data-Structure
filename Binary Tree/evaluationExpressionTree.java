/*Given a expression binary tree with 4 binary operators (+, -, *, /) and integer operands, evaluate it and print the answer.

Complete the function evaluateTree() which takes the address of the root node of tree as parameter and return the result of expression.

Note: The nodes with operators are given as ASCII codes of these operators (e.g. 42 for *(multiply), 43 for +(addition), 45 for -(subtraction) & 47 for /(division)).*/
import java.util.*;
class Node{
    int data;
    Node left,right;

    Node(int d){
        data=d;
        left=right=null;
    }
}
class evaluationExpressionTree{

    Node root;

    int evaluate(Node node){
        if(node==null)  
            return 0;

        if(node.left == null && node.right == null)
            return node.data;
        
        int left = evaluate(node.left);
        int right = evaluate(node.right);

        if(node.data == 42)     
            return left * right;
        if(node.data == 43)     
            return left + right;
        if(node.data == 45)     
        return left- right;
        // if(node.data == 47)     return left/right;

        return left/right;
    }
    public static void main(String[] args) {
        evaluationExpressionTree bt = new evaluationExpressionTree();
        bt.root = new Node(43);
        bt.root.left = new Node(42) ;
        bt.root.left.left = new Node(4) ;
        bt.root.left.right = new Node(5); 
        bt.root.right = new Node(43);
        bt.root.right.left = new Node(2); 
        bt.root.right.right = new Node(4); 

        int result=bt.evaluate(bt.root);
        System.out.println(result);

    }
}