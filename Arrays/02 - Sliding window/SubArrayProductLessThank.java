/*
713. Subarray Product Less Than K

Problem:
Given an integer array nums and an integer k, return the number of contiguous
subarrays where the product of all the elements in the subarray is strictly
less than k.

Examples:

Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8

Explanation:
Valid subarrays are:
[10], [5], [2], [6],
[10,5], [5,2], [2,6], [5,2,6]

Note:
[10,5,2] is not included because its product is 100,
which is NOT strictly less than 100.

Example 2:
Input: nums = [1,2,3], k = 0
Output: 0

Constraints:
1 <= nums.length <= 3 * 10^4
1 <= nums[i] <= 1000
0 <= k <= 10^6

Approach:
- Use the Sliding Window (Two Pointers) technique.
- Maintain a window whose product is always less than k.
- Expand the window by moving the right pointer.
- If the product becomes >= k, shrink the window from the left.
- For every valid window ending at 'right', add
(right - left + 1) to the answer because every suffix of the
current window is also valid.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class SubArrayProductLessThank {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, start = 0, end = 0, count = 0;
        while (end < nums.length) {
            product *= nums[end];

            while (product >= k && start <= end) {
                product /= nums[start];
                start++;
            }
            count += (end - start) + 1;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        SubArrayProductLessThank solution = new SubArrayProductLessThank();
        int[] nums = { 2, 5, 10, 8, 100, 1000, 5, 15 };
        int k = 999;
        int ans = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(ans);
    }

}