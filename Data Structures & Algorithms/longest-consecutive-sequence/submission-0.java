class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSeq = 0;
        HashSet<Integer> numbers = new HashSet<>();
        for (int i : nums) {
            numbers.add(i);
        }

        for (int elem : numbers) {
            int currSeq = 0;
            int prev = elem - 1;
            if (numbers.contains(prev)) { // there is prev so not the starting of the sequence
                continue;
            }

            boolean cont = true;
            int currNum = elem;
            while(cont) {
                currSeq += 1;
                if (numbers.contains(currNum + 1)) {
                    currNum += 1;
                    continue;
                } else {
                    cont = false;
                    break;
                }
            }

            if (currSeq > longestSeq) {
                longestSeq = currSeq;
            }
        }
        return longestSeq;
    }
}
