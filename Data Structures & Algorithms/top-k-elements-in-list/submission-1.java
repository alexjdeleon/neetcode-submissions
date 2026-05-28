class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            countMap.putIfAbsent(num, 0);
            int newCount = countMap.get(num) + 1;
            countMap.put(num, newCount);
            if (newCount > maxCount) {
                maxCount = newCount;
            }
        }

        System.out.println(countMap);

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (Map.Entry<Integer, Integer> countEntry : countMap.entrySet()) {
            int count = countEntry.getValue();
            buckets.putIfAbsent(count, new ArrayList<>());
            buckets.get(count).add(countEntry.getKey());
        }

        System.out.println(buckets);

        int[] results = new int[k];
        int resultCursor = 0;
        for (int i = maxCount; i > 0; i--) {
            if (resultCursor > k - 1) {
                break;
            }
            List<Integer> currentList = buckets.get(i);
            if (currentList != null) {
                for (Integer currentInt : currentList) {
                    if (resultCursor > k - 1) {
                        break;
                    }
                    results[resultCursor] = currentInt;
                    resultCursor++;
                }
            }
        }

        return results;
    }
}
