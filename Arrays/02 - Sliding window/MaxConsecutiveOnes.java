/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
*/

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max_count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                max_count = Math.max(max_count, count);
            } else {
                count = 0;
            }
        }
        return max_count;

    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();

        int[] nums = { 1, 1, 0, 1, 1, 1 };

        int result = solution.findMaxConsecutiveOnes(nums);

        System.out.println("Maximum Consecutive Ones = " + result);
    }
}