// For ceil: if input value is greater than max value of BST return -1
// for floor: if input value is less than min value of BST retur -1

// Print the floor and ceil node values of given key from the binary search tree. If not exists, print -1
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class floor_ceil_bst {

    Node root;

    void findFloorCeil(Node root, int input) {
        System.out.println("Ceil is " + getCeil(root, input));
        System.out.println("Floor is " + getFloor(root, input));
    }

    int getCeil(Node root, int input) {
        if (root == null)
            return -1;

        if (root.data == input)
            return root.data;

        if (root.data < input)
            return getCeil(root.right, input);

        int ceil = getCeil(root.left, input);
        return (ceil >= input) ? ceil : root.data;
    }

    int getFloor(Node root, int input) {
        if(root==null)  return -1; 

        if(root.data==input)    
            return root.data;

        if(root.data > input) 
            return getFloor(root.left, input);
        
        int floor = getFloor(root.right, input);
        return(floor<=input && floor!=-1) ? floor:root.data;
        
    }

    public static void main(String[] args) {
        floor_ceil_bst tree = new floor_ceil_bst();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(8);

        tree.findFloorCeil(tree.root, 10);

    }
}