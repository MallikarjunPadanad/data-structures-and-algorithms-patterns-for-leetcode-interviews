/*
Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
Note: A subarray is a contiguous part of any given array.

Examples:
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.

Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.

Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.

Constraints:
1 ≤ arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 10^6
1 ≤ k ≤ arr.size()

*/

public class MaximumSumSubarrayofSizeK {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if (n < k)
            return -1;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubarrayofSizeK solution = new MaximumSumSubarrayofSizeK();

        int[] arr = { 100, 200, 300, 400 };
        int k = 2;

        int result = solution.maxSubarraySum(arr, k);

        System.out.println("Maximum Sum of Subarray of Size " + k + " = " + result);
    }

}