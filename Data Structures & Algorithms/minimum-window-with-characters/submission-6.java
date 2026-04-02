class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        if (t.isEmpty()) return "";

        Map<Character, Integer> strT = new HashMap<>();
        for (char c : t.toCharArray()) {
            strT.put(c, strT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> substr = new HashMap<>();
        int l = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            substr.put(c, substr.getOrDefault(c, 0) + 1);
            
            while (isSubset(substr, strT)) { // checks if strT is a subset of substr
                int windowLen = r - l + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestStart = l;
                }

                char left = s.charAt(l);
                substr.put(left, substr.get(left) - 1);
                if (substr.get(left) == 0) {
                    substr.remove(left);
                }
                l++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    private boolean isSubset(Map<Character, Integer> main, Map<Character, Integer> subset) {
        for (Map.Entry<Character, Integer> entry : subset.entrySet()) {
            char c = entry.getKey();
            int needed = entry.getValue();

            if (main.getOrDefault(c, 0) < needed) {
                return false;
            }
        }
        return true;
    }
}
