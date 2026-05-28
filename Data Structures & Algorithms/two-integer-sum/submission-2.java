class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new int[0];
        }

        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                currentSum = nums[i] + nums[j];
                if (currentSum == target) {
                    return new int[] {i, j};
                } else {
                    j++;
                }
            }
        }

        return new int[0];
    }
}
