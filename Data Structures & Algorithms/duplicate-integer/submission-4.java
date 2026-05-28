class Solution {

    static {
        for(int i = 0; i < 100; i++) {
            int[] dupes = {i,i,i};
            hasDuplicate(dupes);
        }
    }



    public static boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> encountered = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (encountered.containsKey(nums[i])) {
                return true;
            }
            encountered.put(nums[i], 1);
        }

        return false;
    }
}