package striverssheet.NeetCode.Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, "", 0, 0, res);
        return res;
    }

    public void backtrack(int n, String cur, int open, int close, List<String> res) {
        if (cur.length() == 2 * n) {
            res.add(cur);
            return;
        }
        if (open < n) {
            backtrack(n, cur + "(", open + 1, close, res);
        }
        if (close < open) {
            backtrack(n, cur + ")", open, close + 1, res);
        }

    }
}
