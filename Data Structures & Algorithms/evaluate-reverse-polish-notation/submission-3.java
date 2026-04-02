class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numbers = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                numbers.push(Integer.parseInt(token));
            } else {
                int num2 = numbers.pop();
                int num1 = numbers.pop();

                switch (token) {
                    case "+" -> numbers.push(num1 + num2);
                    case "-" -> numbers.push(num1 - num2);
                    case "*" -> numbers.push(num1 * num2);
                    case "/" -> numbers.push(num1 / num2);                  
                }
            }
        }
        return numbers.pop();
    }
}
