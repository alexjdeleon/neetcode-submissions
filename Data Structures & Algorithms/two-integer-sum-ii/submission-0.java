class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int currentSum = numbers[left] + numbers[right];
            if(currentSum == target){
                return new int[]{left + 1,right + 1}; // add one to make it 1-based
            } else if (currentSum < target) {
                // incremenet left to increase the sum
                left++;
            } else {
                // decrement right to decrease the sum
                right--;
            }
        }
        return null; // no reachable
    }
}
