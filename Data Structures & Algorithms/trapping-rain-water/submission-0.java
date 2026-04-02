class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        maxL[0] = 0;
        maxR[height.length - 1] = 0;

        int ml = 0;
        for (int i = 1; i < height.length; i++) {
            int curr = height[i - 1];
            if (curr > ml) {
                ml = curr;
            }
            maxL[i] = ml;
        }

        int mr = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            int curr = height[i + 1];
            if (curr > mr) {
                mr = curr;
            }
            maxR[i] = mr;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int water = Math.min(maxL[i], maxR[i]) - height[i];
            if(water > 0) {
                res += water;
            }
        }

        return res;
    }
}
