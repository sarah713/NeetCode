package SlidingWindow;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26]; // To store the count of characters in the window
        int start = 0; // Start of the window
        int maxLen = 0; // Maximum length of the window with the same character

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            charCount[ch - 'A']++; // Increment the count of the current character in the window

            // Calculate the number of operations needed to make all characters in the window the same
            int operationsNeeded = end - start + 1 - getMaxCount(charCount);

            // If the number of operations needed exceeds k, we need to shrink the window
            while (operationsNeeded > k) {
                charCount[s.charAt(start) - 'A']--; // Decrease the count of the character at the start of the window
                start++; // Move the start of the window forward
                operationsNeeded = end - start + 1 - getMaxCount(charCount); // Recalculate operations needed
            }

            // Update the maximum length of the window if applicable
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
    private int getMaxCount(int[] charCount) {
        int maxCount = 0;
        for (int count : charCount) {
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
