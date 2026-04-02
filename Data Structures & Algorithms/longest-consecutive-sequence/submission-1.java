class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSeq = 0;
        HashSet<Integer> numbers = new HashSet<>();
        for (int i : nums) {
            numbers.add(i);
        }

        for (int n : numbers) {
            if (!numbers.contains(n - 1)) {
                int currSeq = 1;
                while (numbers.contains(n + currSeq)) {
                    currSeq++;
                }
                longestSeq = Math.max(currSeq, longestSeq);
            }
        }
        return longestSeq;
    }
}
