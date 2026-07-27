class Solution {
    public String intToRoman(int num) {
        // Arrays representing the values and their corresponding Roman symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        // Iterate through each value, greedily appending the corresponding symbol
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        
        return result.toString();
    }
}