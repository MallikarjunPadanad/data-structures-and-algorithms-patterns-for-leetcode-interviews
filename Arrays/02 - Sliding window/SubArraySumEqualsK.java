/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

 
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
*/

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // brute
        // int n = nums.length;
        // int count = 0;

        // for (int start = 0; start < n; start++) {
        // for (int end = start; end < n; end++) {

        // int sum = 0;

        // for (int i = start; i <= end; i++) {
        // sum += nums[i];
        // }

        // if (sum == k) {
        // count++;
        // }
        // }
        // }
        // return count;

        // better
        // int n = nums.length;
        // int count = 0;

        // for (int start = 0; start < n; start++) {

        // int sum = 0;

        // for (int end = start; end < n; end++) {

        // sum += nums[end];

        // if (sum == k) {
        // count++;
        // }
        // }
        // }
        // return count;

        // Prefix sum + HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int total = 0;

        for (int num : nums) {
            prefixSum += num;

            total += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return total;
    }

    public static void main(String[] args) {

        SubArraySumEqualsK solution = new SubArraySumEqualsK();
        int[] nums = { 2, 1, 7, -4, 2, 1, 3, 4, -15, 2, -3, 6 };
        int k = 6;
        int ans = solution.subarraySum(nums, k);
        System.out.println(ans);

    }

    // Time complexity : O(n)
    // space complexity : O(n)

}
