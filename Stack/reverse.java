/* the comments in main function is another method by using collections */

import java.util.*;

public class reverse {
    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> s1 = new Stack<>();

    static void printStack(Stack<Integer> s) {
        System.out.println(s);
    }

    static void reverseStack() {
        while (s.size() > 0) {
            int x = s.peek();
            s.pop();
            s1.push(x);
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        s.push(23);
        s.push(22);
        s.push(21);
        s.push(20);
        printStack(s);
        reverseStack();
        // Collections.reverse(s);
        // printStack(s);
        printStack(s1);

    }
}
