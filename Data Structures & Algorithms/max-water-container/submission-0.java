class Solution {
    public int maxArea(int[] heights) {
        
        // strategy: two pointer, keeping track of max area

        int left = 0;
        int right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right){
            int maxHeight = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currentArea = maxHeight * width;
            maxArea = Math.max(currentArea, maxArea);
            if(heights[left] < heights[right]) {
                // move left pointer to find bigger height
                left++;
            } else if (heights[right] < heights[left]){
                // move right pointer to find a bigger height
                right--;
            } else {
                // equal so move both
                left++;
                right--;
            }
        }

        return maxArea;
    }

}
