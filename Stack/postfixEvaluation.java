import java.util.*;

public class postfixEvaluation {

    static Stack<Integer> s = new Stack<>();

    static void convertPostfix(String str) {
        int op1, op2;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c))
                s.push(c-'0');
            else {
                op2 = s.pop();
                op1 = s.pop();
                switch (c) {
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

                }
            }
        }
        int answer = s.pop();
        System.out.println(answer);
    }

    public static void main(String[] args) {
        String str;
        Scanner obj = new Scanner(System.in);
        str = obj.next();
        convertPostfix(str);
    }
}