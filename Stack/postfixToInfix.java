import java.util.*;

public class postfixToInfix {

    static boolean isOperator(char x) {
        switch(x)
        {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    static String getInfix(String str) {
        Stack<String> s = new Stack<String>();

        for (int i = 0; i < str.length(); i++) {
            if (!isOperator(str.charAt(i)))
                s.push(str.charAt(i) + "");
            else{
                String ob2 = s.pop();
                String ob1 = s.pop();
                s.push('('+ ob1 + str.charAt(i) + ob2 + ')');
            }
        }
        return(s.pop());
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str;
        str = obj.next();
        System.out.println(getInfix(str));
    }
}