class Solution {

    static {
        for(int i = 0; i < 100; i++) {
            int[] dupes = {i,i,i};
            hasDuplicate(dupes);
        }
    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> encountered = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (encountered.contains(nums[i])) {
                return true;
            }
            encountered.add(nums[i]);
        }

        return false;
    }
}