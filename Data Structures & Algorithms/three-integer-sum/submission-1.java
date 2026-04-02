class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            
            if (a > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int thrSum = a + nums[l] + nums[r];

                if (thrSum > 0) {
                    r--;
                } else if (thrSum < 0) {
                    l++;
                } else {
                    res.add(List.of(a, nums[l], nums[r]));
                    r--;
                    l++;
                    
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }

        return res;
    }
}
