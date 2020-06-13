import java.util.Scanner;
import java.util.*;

public class infixToPrefix {

    static Stack<Character> s = new Stack<>();

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static void toPrefix(StringBuffer str) {
        String prefix = new String("");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                prefix += c;
            } else if (c == '(')
                s.push(c);
            else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(')
                    prefix += s.pop();

                s.pop();
            } else {
                while (!s.isEmpty() && Prec(c) <= Prec(s.peek()))
                    prefix += s.pop();

                s.push(c);
            }

        }

        while (!s.isEmpty())
            prefix += s.pop();
        
        StringBuffer prefixresult = new StringBuffer(prefix);
        prefixresult.reverse();
        System.out.println(prefixresult);

    }

    public static void main(String[] args) {
        String str;
        Scanner obj = new Scanner(System.in);
        str = obj.next();
        StringBuffer st = new StringBuffer(str);
        st.reverse();
        toPrefix(st);

    }
}