/*
Given a binary array nums, sort it in-place so that all 0's come before all 1's.

You must solve it in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,1,1,0]
Output: [0,0,0,1,1,1]

Example 2:
Input: nums = [1,1,1,0,0]
Output: [0,0,1,1,1]

Example 3:
Input: nums = [0]
Output: [0]

Example 4:
Input: nums = [1]
Output: [1]

Constraints:

1 <= nums.length <= 10^4
nums[i] is either 0 or 1.

Follow-up:
Can you solve it in O(n) time complexity using O(1) extra space?
*/

import java.util.Arrays;

public class Sort0and1 {

    public void sortZeroOne(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && arr[left] == 0) {
                left++;
            }
            while (left < right && arr[right] == 1) {
                right--;

            }
            if (left < right) {
                swap(arr, right, left);
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
        Sort0and1 solution = new Sort0and1();

        int[] arr = { 0, 1, 0, 1, 1, 0 };

        solution.sortZeroOne(arr);

        System.out.println(Arrays.toString(arr));
    }
}