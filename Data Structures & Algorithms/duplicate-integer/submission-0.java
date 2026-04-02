class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}