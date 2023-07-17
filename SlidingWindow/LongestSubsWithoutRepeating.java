package SlidingWindow;

import java.util.HashSet;

public class LongestSubsWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
