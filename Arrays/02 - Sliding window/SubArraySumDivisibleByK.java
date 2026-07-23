/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


Example 2:
Input: nums = [5], k = 9
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 10^4
-104 <= nums[i] <= 10^4
2 <= k <= 10^4
*/

import java.util.HashMap;

public class SubArraySumDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {

        // brute
        // int n = nums.length;
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        // int sum = 0;

        // for (int j = i; j < n; j++) {
        // sum += nums[j];

        // if (((sum % k) + k) % k == 0) {
        // count++;
        // }
        // }
        // }

        // return count;

        // better

        // int n = nums.length;
        // int[] prefix = new int[n + 1];

        // for (int i = 0; i < n; i++) {
        // prefix[i + 1] = prefix[i] + nums[i];
        // }

        // int count = 0;

        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < n; j++) {

        // int sum = prefix[j + 1] - prefix[i];

        // if (((sum % k) + k) % k == 0) {
        // count++;
        // }
        // }
        // }

        // return count;

        // Optimal (HashMap+ Prefix reminder)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int total = 0;
        for (int num : nums) {
            prefixSum += num;

            int rem = prefixSum % k;
            if (rem < 0) {
                rem = k + rem;
            }
            total += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);

        }
        return total;
    }


    public static void main(String[] args) {
        SubArraySumDivisibleByK solution = new SubArraySumDivisibleByK();
        int[] nums = { 2, 3, -8, -3, 11, 4, 8, 6, 9, 4 };
        int k = 7;
        int ans = solution.subarraysDivByK(nums, k);
        System.out.println(ans);
    }
}
