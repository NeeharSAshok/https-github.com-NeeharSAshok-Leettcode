class Solution {
    public String countAndSay(int n) {
        String current = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int length = current.length();
            int j = 0;
            
            while (j < length) {
                char c = current.charAt(j);
                int count = 0;
                
                while (j < length && current.charAt(j) == c) {
                    count++;
                    j++;
                }
                
                next.append(count).append(c);
            }
            
            current = next.toString();
        }
        
        return current;
    }
}