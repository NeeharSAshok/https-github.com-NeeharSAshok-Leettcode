class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (e.g., -121 != 121-)
        // Also, if the last digit is 0, the first must be 0 (only possible for 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        int original = x;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit 
        // by revertedNumber/10. For example, at the end of the loop for 121:
        // x = 1, revertedNumber = 12. Since the middle digit doesn't matter 
        // in palindromes, we can just remove it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
