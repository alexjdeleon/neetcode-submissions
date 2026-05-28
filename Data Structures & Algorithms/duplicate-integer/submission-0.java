class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> encountered = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(encountered.containsKey(nums[i])) {
                return true;
            }
            encountered.put(nums[i], 1);
        }

        return false;
    }
}