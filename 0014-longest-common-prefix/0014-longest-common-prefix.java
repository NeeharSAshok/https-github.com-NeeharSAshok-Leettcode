class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Loop through the characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Compare this character with the corresponding character in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If we reach the end of any string or a character mismatch occurs
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If the entire first string is a common prefix
        return strs[0];
    }
}