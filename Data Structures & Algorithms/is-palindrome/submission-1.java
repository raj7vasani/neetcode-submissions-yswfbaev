class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder clean = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                clean.append(c);
            }
        }

        int front = 0;
        int back = clean.length() - 1;
        while (front < back) {
            if (clean.charAt(front) != clean.charAt(back)) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}