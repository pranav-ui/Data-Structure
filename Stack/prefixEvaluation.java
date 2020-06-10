import java.util.*;
import java.lang.Math;  
public class prefixEvaluation {
    static Stack<Integer> s = new Stack<Integer>();

    static void solvePrefix(String str) {
        int op1, op2;
        for (int i = (str.length() - 1); i >= 0; i--) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                s.push(ch - '0');
            } else {
                op1 = s.pop();
                op2 = s.pop();
                switch (ch) {
                    case '+':
                        s.push(op1 + op2);
                        break;
                    case '-':
                        s.push(op1 - op2);
                        break;
                    case '*':
                        s.push(op1 * op2);
                        break;
                    case '/':
                        s.push(op1 / op2);
                        break;
                    case '^':
                        s.push((int)Math.pow(op1, op2));
                        break;
                }
            }
        }
        System.out.println(s.pop());
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str;
        str = obj.next();
        solvePrefix(str);
    }
}