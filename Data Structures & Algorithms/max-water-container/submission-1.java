class Solution {
    public int maxArea(int[] heights) {
        int maxAr = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            int b = 1;
            for (int j = i + 1; j < heights.length; j++) {
                int h = Math.min(heights[i], heights[j]);
                int ar = h * b;
                if (ar > maxAr) maxAr = ar;
                b++;
            }
        }

        return maxAr;
    }
}
