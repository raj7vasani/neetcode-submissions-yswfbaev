class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, target);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> cur, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        dfs(nums, i, cur, target - nums[i]);
        cur.remove(cur.size() - 1);
        dfs(nums, i + 1, cur, target);
    }
}
