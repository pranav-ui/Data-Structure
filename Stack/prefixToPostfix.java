import java.util.*;

public class prefixToPostfix {

    static Stack<String> s = new Stack<String>();

    static boolean isOperator(char c)
    {
        switch(c){
            case '+': 
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    static void toPostfix(String str)
    {
        String postfix = new String("");
        String op1,op2;
        for(int i=str.length()-1;i>=0;i--)
        {
            char c = str.charAt(i);
            if(!isOperator(c))
            {
                s.push(c+"");
            }
            else{
                op1=s.pop();
                op2=s.pop();
                postfix = op1+op2+c;
                s.push(postfix);
            }
        }
        System.out.println(s.pop());
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str = obj.next();
        toPostfix(str);
    }
}