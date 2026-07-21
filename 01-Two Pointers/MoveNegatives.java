/*
Given an integer array nums, move all negative elements to the end of the array while maintaining the relative order of the non-negative elements (0 and positive numbers).

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [1, -2, 3, -4, 5, -6]
Output: [1, 3, 5, -4, -2, -6]

Explanation:
The non-negative elements (1, 3, 5) remain in their original order.
The negative elements (-2, -4, -6) are moved to the end.

Example 2:
Input: nums = [-1, -2, -3]
Output: [-1, -2, -3]

Explanation:
All elements are negative, so the array remains unchanged.

Example 3:
Input: nums = [4, 0, 7, 2]
Output: [4, 0, 7, 2]

Explanation:
There are no negative elements, so the array remains unchanged.

Example 4:
Input: nums = [0, -1, 2, -3, 4]
Output: [0, 2, 4, -3, -1]

Constraints:

1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1

Follow-up:
Can you solve it in O(n) time complexity using O(1) extra space?
*/

import java.util.Arrays;

public class MoveNegatives {

    public void moveNegativesToEnd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && arr[left] >= 0) {
                left++;
            }

            while (left < right && arr[right] < 0) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MoveNegatives solution = new MoveNegatives();

        int[] arr = { 1, -2, 3, -4, 5, -6 };

        solution.moveNegativesToEnd(arr);

        System.out.println(Arrays.toString(arr));
    }
}
