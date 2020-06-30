import java.util.*;
public class postfixToPrefix {

    static boolean isOperator(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    static void toPrefix(String str)
    {
        Stack<String> s = new Stack<String>();
        String prefix = new String("");
        for(int i=0;i<str.length();i++)
        {
            if(!isOperator(str.charAt(i)))
                s.push(str.charAt(i)+"");
            else{
                String op2 = s.pop();
                String op1 = s.pop();
                prefix = str.charAt(i)+op1+op2;
                s.push(prefix);
            }
        }
        System.out.println(s.pop());
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str = obj.next();
        toPrefix(str);
    }
}