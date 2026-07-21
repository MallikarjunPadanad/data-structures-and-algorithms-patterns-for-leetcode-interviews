/*
Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target

The solution set must not contain duplicate quadruplets.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output:
[
  [-2,-1,1,2],
  [-2,0,0,2],
  [-1,0,0,1]
]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output:
[
  [2,2,2,2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] arr, int target) {

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 4) {
            return result;
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            long min1 = (long) arr[i] + arr[i + 1] + arr[i + 2] + arr[i + 3];
            if (min1 > target) {
                break;
            }

            long max1 = (long) arr[i] + arr[n - 1] + arr[n - 2] + arr[n - 3];
            if (max1 < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                long min2 = (long) arr[i] + arr[j] + arr[j + 1] + arr[j + 2];
                if (min2 > target) {
                    break;
                }

                long max2 = (long) arr[i] + arr[j] + arr[n - 1] + arr[n - 2];
                if (max2 < target) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                arr[i],
                                arr[j],
                                arr[left],
                                arr[right]));

                        while (left < right && arr[left] == arr[left + 1]) {
                            left++;
                        }

                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FourSum solution = new FourSum();

        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        List<List<Integer>> result = solution.fourSum(arr, target);

        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Target : " + target);
        System.out.println("Output : " + result);
    }
}

// Time Complexity: O(n³)
// Auxiliary Space Complexity: O(1)
// Space Complexity (including output): O(k) k is the number of unique quadruplets returned.