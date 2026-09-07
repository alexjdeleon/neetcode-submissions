class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }

        if(s.length() == 1){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            Character leftChar = s.charAt(left);
            Character rightChar = s.charAt(right);
            while(isNotAlphanumeric(leftChar) && left < right){
                left++;
                leftChar = s.charAt(left);
            }
            while(isNotAlphanumeric(rightChar) && left < right){
                right--;
                rightChar = s.charAt(right);
            }

            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isNotAlphanumeric(Character c){
        return !Character.isDigit(c) && !Character.isLetter(c);
    }
}
