/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.


Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:
3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] arr) {

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 3) {
            return result;
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {

            if (arr[i] > 0) {
                break;
            }

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] + arr[i + 1] + arr[i + 2] > 0) {
                break;
            }

            if (arr[i] + arr[n - 2] + arr[n - 1] < 0) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }

                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ThreeSum solution = new ThreeSum();

        int[] arr = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> result = solution.threeSum(arr);

        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + result);
    }
}

// Time Complexity: O(n²)
// Auxiliary Space Complexity: O(1)
// Space Complexity (including output): O(n²)