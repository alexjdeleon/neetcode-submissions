class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];

        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixProducts[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            suffixProducts[j] = suffixProduct;
            suffixProduct *= nums[j];
        }

        int[] result = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            if (k == 0) {
                result[k] = suffixProducts[k];
            } else if (k == nums.length - 1) {
                result[k] = prefixProducts[k];
            } else {
                result[k] = suffixProducts[k] * prefixProducts[k];
            }
        }
        return result;
    }
}
