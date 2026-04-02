class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ("({[".indexOf(curr) != -1) {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (curr == ')' && top != '('
                ||  curr == '}' && top != '{'
                ||  curr == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
