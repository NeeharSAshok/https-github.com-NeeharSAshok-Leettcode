class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case for 32-bit signed integer overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Use long to prevent overflow during absolute value conversion
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        int result = 0;
        
        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            
            // Double the divisor and the multiple until it exceeds the dividend
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            dvd -= temp;
            result += multiple;
        }
        
        return negative ? -result : result;
    }
}