class MinStack {
    private List<Integer> stack;
    int size;
    int min;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.size = 0;
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val < min) {
            min = val;
        }
        stack.add(val);
        size++;
    }
    
    public void pop() {
        int res = stack.remove(size - 1);
        size--;

        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else if (res == min) {
            min = Collections.min(stack);           
        }
    }
    
    public int top() {
        return stack.get(size - 1);
    }
    
    public int getMin() {
        return min;
    }
}
