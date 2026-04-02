class MinStack {
    private List<Integer> stack;
    private int size;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.size = 0;
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        size++;
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int res = stack.remove(size - 1);
        size--;

        if (res == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.get(size - 1);
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
