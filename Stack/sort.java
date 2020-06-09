import java.util.*;
public class sort {

    static Stack<Integer> s = new Stack<Integer>();
    public static void main(String[] args) {
        s.push(23);
        s.push(21);
        s.push(34);
        s.push(40);
        s.push(1);
        System.out.println(s);
        Collections.sort(s);
        System.out.println(s);
    }
}