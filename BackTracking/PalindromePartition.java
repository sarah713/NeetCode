package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(String s, int idx, List<List<String>> res, List<String> cur) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                cur.add(s.substring(idx, i + 1));
                helper(s, i + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
