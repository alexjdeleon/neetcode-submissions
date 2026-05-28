class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.putIfAbsent(num, 0);
            int newCount = countMap.get(num) + 1;
            countMap.put(num, newCount);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (Map.Entry<Integer, Integer> countEntry : countMap.entrySet()) {
            int count = countEntry.getValue();
            buckets.putIfAbsent(count, new ArrayList<>());
            buckets.get(count).add(countEntry.getKey());
        }

        int[] results = new int[k];
        int resultCursor = 0;
        for (int i = nums.length; i > 0; i--) {
            if (resultCursor > k - 1) {
                break;
            }
            if (buckets.containsKey(i)) {
                List<Integer> currentList = buckets.get(i);
                for (Integer currentInt : currentList) {
                    results[resultCursor] = currentInt;
                    resultCursor++;
                    if (resultCursor > k - 1) {
                        break;
                    }
                }
            }
        }

        return results;
    }
}
