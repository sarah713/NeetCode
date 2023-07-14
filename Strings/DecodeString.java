package striverssheet.NeetCode.Strings;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                st.push(c);
            } else {
                StringBuilder curSb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals('[')) {
                    curSb.insert(0, st.pop());
                }
                st.pop(); // Pop the '[' character

                StringBuilder countStr = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    countStr.insert(0, st.pop());
                }
                int count = Integer.parseInt(countStr.toString());

                String repeatedStr = curSb.toString().repeat(count);
                for (char ch : repeatedStr.toCharArray()) {
                    st.push(ch);
                }
            }
        }

        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }

}
