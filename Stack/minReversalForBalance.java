import java.util.*;

public class minReversalForBalance {

    static Stack<Character> s = new Stack<>();

    static int minReversal(String str) {
        int len = str.length();
        if (len % 2 != 0)
            return -1; 
        for (int i = 0; i < len; i++) {
            char x = str.charAt(i);
            if (x == '}' && !s.empty()) {
                if (s.peek() == '{')
                    s.pop();
                else
                    s.push(x);
            } else
                s.push(x);
        }

        int newSize = s.size();
        if(newSize==0)
            return 0;
        int count = 0;
        while (s.peek() == '{' && !s.empty()) {
            count++;
            s.pop();
        }

        return (newSize / 2 + count % 2);
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str = obj.next();
        System.out.println(minReversal(str));

    }
}