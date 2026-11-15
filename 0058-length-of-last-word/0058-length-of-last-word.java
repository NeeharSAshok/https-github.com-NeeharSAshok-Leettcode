class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;
        
        // Step 1: Skip any trailing spaces from the end of the string
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        // Step 2: Count characters of the last word until we hit another space or the beginning
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}