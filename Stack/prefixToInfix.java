import java.util.*;

public class prefixToInfix {

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

    static void toInfix(String str)
    {
        String infix = new String("");
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
                infix = '('+ op1 + c + op2 +')';
                s.push(infix);
            }
        }
        System.out.println(s.pop());
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str = obj.next();
        toInfix(str);
    }
}