import java.util.*;

class balanceBracket {

    static Stack<Character> first, second, third;

    static boolean isBalance(String str) {
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(')
                first.push(x);
            else if (x == '{')
                second.push(x);
            else if (x == '[')
                third.push(x);
            else{
                if(x==')')
                {
                    if(first.isEmpty()) return false;
                    first.pop();
                }
                else if(x=='}')
                {
                    if(second.isEmpty()) return false;
                    second.pop();
                }
                else if(x==']')
                {
                    if(third.isEmpty()) return false;
                    third.pop();
                }
            }
        }
        if(!first.isEmpty() || !second.isEmpty() || !third.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        first = new Stack<Character>();
        second = new Stack<Character>();
        third = new Stack<Character>();
        String str = obj.next();
        if (isBalance(str))
            System.out.println("Balanced");
        else
            System.out.println("Unbalanced");

    }
}