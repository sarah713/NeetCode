package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public static final HashMap<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
            return res;
        }
        helper(digits, res, new StringBuilder(), 0);
        return res;
    }

    public void helper(String digits, List<String> res, StringBuilder cur, int idx) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = map.get(digit);

        for (char c : letters.toCharArray()) {
            cur.append(c);
            helper(digits, res, cur, idx + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
