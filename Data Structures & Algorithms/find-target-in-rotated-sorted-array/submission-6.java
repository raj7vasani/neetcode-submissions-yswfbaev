class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
               return mid; 
            }

            if (nums[mid] > nums[r]) { // search right for pivot
                l = mid + 1;
            } else { // search left 
                r = mid;
            }
        }

        int pivot = l;
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            l = pivot;
            r = nums.length - 1;
        } else {
            l = 0;
            r = pivot - 1;
        }
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
               return mid; 
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
