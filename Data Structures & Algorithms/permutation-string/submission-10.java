class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> str1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            str1.put(c, str1.getOrDefault(c, 0) + 1);
        }

        int windowSize = s1.length();
        Map<Character, Integer> substr = new HashMap<>();

        for (int i = 0; i < windowSize; i++) {
            char c = s2.charAt(i);
            substr.put(c, substr.getOrDefault(c, 0) + 1);
        }

        if (substr.equals(str1)) return true;

        int l = 0;
        for (int r = windowSize; r < s2.length(); r++) {
            char left = s2.charAt(l);
            int newCount = substr.get(left) - 1;
            if (newCount == 0) {
                substr.remove(left);
            } else {
                substr.put(left, newCount);
            }

            l++;

            char right = s2.charAt(r);
            substr.put(right, substr.getOrDefault(right, 0) + 1);

            if (substr.equals(str1)) return true;
        }

        return false;
    }
}