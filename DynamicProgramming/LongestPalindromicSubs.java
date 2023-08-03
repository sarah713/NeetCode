package DynamicProgramming;

public class LongestPalindromicSubs {
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            String oddLen = isPalin(s, i, i);

            String evenLen = isPalin(s, i, i + 1);

            if (oddLen.length() > longest.length()) {
                longest = oddLen;
            }
            if (evenLen.length() > longest.length()) {
                longest = evenLen;
            }
        }
        return longest;
    }

    public static String isPalin(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababcda"));
    }
}
