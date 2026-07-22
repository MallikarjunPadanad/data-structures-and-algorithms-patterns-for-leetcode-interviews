/*
LeetCode 42 - Trapping Rain Water

You are given n non-negative integers representing an elevation map
where the width of each bar is 1.

Compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
1 <= height.length <= 2 * 10^4
0 <= height[i] <= 10^5
*/

import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {

        TrappingRainWater solution = new TrappingRainWater();

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        int result = solution.trap(height);

        System.out.println("Input  : " + Arrays.toString(height));
        System.out.println("Output : " + result);
    }
}