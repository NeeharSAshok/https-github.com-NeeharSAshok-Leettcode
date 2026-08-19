class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the special case for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result using XOR
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        // Convert both numbers to long to prevent overflow during absolute value conversion
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        int quotient = 0;
        
        // Subtract multiples of the divisor using bitwise shifts
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            
            // Shift left until temp * 2 exceeds dvd
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            dvd -= temp;
            quotient += multiple;
        }
        
        return isNegative ? -quotient : quotient;
    }
}