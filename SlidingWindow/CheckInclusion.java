
package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                if (windowMap.get(leftChar) == 1) {
                    windowMap.remove(leftChar);
                } else {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }

            if (windowMap.equals(s1Map)) {
                return true;
            }
        }
        return false;
    }
}
