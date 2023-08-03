package DynamicProgramming;

public class PalindromeStrings {
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += helper(s, i, i);
            cnt += helper(s, i, i + 1);
        }
        return cnt;
    }

    public int helper(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
