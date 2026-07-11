import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // 'right' pointer expands the window
        for (int right = 0; right < n; right++) {
            // If a duplicate is found, shrink the window from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add the current character and update max length
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}