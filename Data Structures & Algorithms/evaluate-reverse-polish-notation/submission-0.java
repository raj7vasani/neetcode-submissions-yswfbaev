class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (!isOperator(curr)) {
                numbers.push(Integer.parseInt(tokens[i]));
            } else {
                int num1 = 0;
                int num2 = 0;
                int res = 0;
                switch (curr) {
                    case "+":
                        num2 = numbers.pop();
                        num1 = numbers.pop();
                        res = num1 + num2;
                        numbers.push(res);
                        break;
                    case "-":
                        num2 = numbers.pop();
                        num1 = numbers.pop();
                        res = num1 - num2;
                        numbers.push(res);
                        break;
                    case "*":
                        num2 = numbers.pop();
                        num1 = numbers.pop();
                        res = num1 * num2;
                        numbers.push(res);    
                        break;
                    case "/":
                        num2 = numbers.pop();
                        num1 = numbers.pop();
                        if (!(num2 == 0)) {
                            res = num1 / num2;
                        } else {
                            return -1;
                        }
                        numbers.push(res);    
                        break;
                    default:
                        continue;                      
                }
            }
        }
        return numbers.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
