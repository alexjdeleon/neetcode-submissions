class Solution {
    public int[] productExceptSelf(int[] nums) {
        // calculate all prefix products first
        int[] result = new int[nums.length];
        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // incorporate suffix products
        int suffixProduct = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= suffixProduct;
            suffixProduct *= nums[j];
        }

        return result;
    }
}
