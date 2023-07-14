package striverssheet.NeetCode.Stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
    Stack<String> st = new Stack<>();
    Set<String> op = new HashSet<>(Arrays.asList("+","-","*","/"));

    for(
    String s:tokens)
    {
        // if it is an integer push it
        if (!op.contains(s)) {
            st.push(s);
        } else {

            int a = Integer.parseInt(st.pop());
            int b = Integer.parseInt(st.pop());
            if (s.equals("+")) {
                st.push(String.valueOf(a + b));
            } else if (s.equals("/")) {
                st.push(String.valueOf(b / a));
            } else if (s.equals("-")) {
                st.push(String.valueOf(b - a));
            } else {
                st.push(String.valueOf(a * b));
            }

        }

    }return Integer.valueOf(st.peek());
}}
