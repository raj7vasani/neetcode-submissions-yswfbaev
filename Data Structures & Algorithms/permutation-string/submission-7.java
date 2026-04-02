class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> str1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            str1.put(c, str1.getOrDefault(c, 0) + 1);
        }

        if (s1.length() == s2.length()) {
            Map<Character, Integer> str2 = new HashMap<>();
            for (char c : s2.toCharArray()) {
                str2.put(c, str2.getOrDefault(c, 0) + 1);
            }            
        }

        for (int i = 0; i < s2.length(); i++) {
            int j = i + (s1.length());
            if (j < s2.length()) {
                String sub = s2.substring(i, j);

                Map<Character, Integer> substr = new HashMap<>();
                for (char c : sub.toCharArray()) {
                    substr.put(c, substr.getOrDefault(c, 0) + 1);
                }   
                if (substr.equals(str1)) {
                    return true;
                }
            } else {
                String sub = s2.substring(i);

                Map<Character, Integer> substr = new HashMap<>();
                for (char c : sub.toCharArray()) {
                    substr.put(c, substr.getOrDefault(c, 0) + 1);
                } 
                  
                if (substr.equals(str1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
