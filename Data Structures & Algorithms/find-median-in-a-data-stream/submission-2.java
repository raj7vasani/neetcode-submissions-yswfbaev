class MedianFinder {
    private PriorityQueue<Double> pq;

    public MedianFinder() {
        this.pq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        double n = (double) num;
        pq.add(n);
    }
    
    public double findMedian() {
        int n = pq.size();

        if (n % 2 == 0) { // even case
            int mid =  (n - 1) / 2;
            double[] x = pq.stream().mapToDouble(Double::doubleValue).toArray();
            Arrays.sort(x);
            return (x[mid] + x[mid + 1]) / 2;
        } else {
            int mid = (n - 1) / 2;
            double[] x = pq.stream().mapToDouble(Double::doubleValue).toArray();
            Arrays.sort(x);
            return x[mid];
        }
    }
}
