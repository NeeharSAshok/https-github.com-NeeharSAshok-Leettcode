class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int total = 1 << n;
        
        for (int i = 0; i < total; i++) {
            // The standard binary-reflected Gray code formula
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}