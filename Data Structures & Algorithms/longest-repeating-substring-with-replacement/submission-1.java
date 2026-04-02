class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        Map<Character, Integer> count = new HashMap<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            int window = r - l + 1;
            int maxFreq = 0;
            for (int val : count.values()) {
                maxFreq = Math.max(val, maxFreq);
            }
            if (window - maxFreq <= k) {
                max = window;
                continue;
            } else {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
        }

        return max;
    }
}
