/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]


Example 2:
Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
*/

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] != 0) {
                swap(arr, right, left);
                left++;
            }

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();
        int[] arr = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}