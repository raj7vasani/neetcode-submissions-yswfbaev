class MedianFinder {
    private PriorityQueue<Double> min;
    private PriorityQueue<Double> max;

    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        double n = (double) num;
        
        if (min.isEmpty() && max.isEmpty()) {
            min.add(n);
            return;
        }

        if (n > min.peek()) {
            min.add(n);
        } else {
            max.add(n);
        }
                    
        if (min.size() < (max.size() - 1)) { // rebalance
            double x = max.poll();
            min.add(x);
        } 

        if (max.size() < (min.size() - 1)) { // rebalance
            double x = min.poll();
            max.add(x);
        }
    }
    
    public double findMedian() {
        int size = min.size() + max.size();

        if (size % 2 == 0) { // even case
            return (min.peek() + max.peek()) / 2;
        } else { // odd case
            if (min.size() > max.size()) {
                return min.peek();
            } else {
                return max.peek();
            }
        }
    }
}
