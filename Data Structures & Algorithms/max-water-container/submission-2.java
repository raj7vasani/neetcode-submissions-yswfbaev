class Solution {
    public int maxArea(int[] heights) {
        int maxAr = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int ar = (r - l) * Math.min(heights[l], heights[r]);
            if (ar > maxAr) {
                maxAr = ar;
            }

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxAr;
        
    }
}
