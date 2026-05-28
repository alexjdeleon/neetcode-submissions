class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new int[0];
        }

        // keyed by the amount needed by the given index to reach the target
        Map<Integer,Integer> complementMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // check if an existing index needs this amount to reach the target
            if(complementMap.containsKey(nums[i])) {
                return new int[]{complementMap.get(nums[i]), i};
            }
            // add an entry for the required difference to reach target
            complementMap.put(target - nums[i], i);
        }

        return new int[0];
    }
}
