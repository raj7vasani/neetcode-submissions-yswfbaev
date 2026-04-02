class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> count = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                
                int maxFreq = 0;
                for (int freq : count.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                }

                int substrLen = j - i + 1;
                if (substrLen - maxFreq <= k) {
                    max = Math.max(max, substrLen);
                }
            }
        }

        return max;
    }
}
