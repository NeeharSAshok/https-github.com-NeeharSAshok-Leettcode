import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCounts.containsKey(sub)) {
                    seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);
                    count++;

                    while (seenWords.get(sub) > wordCounts.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == numWords) {
                        result.add(left);
                        String leftSub = s.substring(left, left + wordLen);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}