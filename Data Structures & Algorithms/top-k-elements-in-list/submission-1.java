class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i > 0 && idx < k; i--) {
            for (int n : buckets[i]) {
                res[idx++] = n;
                if (idx == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
