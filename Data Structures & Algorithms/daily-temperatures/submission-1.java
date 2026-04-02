class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Pair> temps = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (temps.isEmpty()) {
                temps.push(new Pair(i, temperatures[i]));
            } else {
                if (temperatures[i] <= temps.peek().getVal()) {
                    temps.push(new Pair(i, temperatures[i]));
                } else {
                    while (!temps.isEmpty() && temperatures[i] > temps.peek().getVal()) {
                        Pair elem = temps.pop();
                        result[elem.getIdx()] = i - elem.getIdx();
                    }
                    temps.push(new Pair(i, temperatures[i]));
                }
            }
        }


        return result;
    }
}

class Pair {
    private int idx;
    private int val;

    public Pair(int a, int b) {
        this.idx = a;
        this.val = b;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getVal() {
        return this.val;
    }
}
