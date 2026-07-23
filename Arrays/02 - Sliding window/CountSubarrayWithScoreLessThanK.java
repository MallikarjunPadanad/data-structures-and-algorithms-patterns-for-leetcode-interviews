/*
LeetCode 2302. Count Subarrays With Score Less Than K

Problem:
The score of an array is defined as:

    score = (sum of elements) × (length of the array)

Given a positive integer array nums and an integer k, return the number of
non-empty subarrays whose score is strictly less than k.

A subarray is a contiguous sequence of elements within the array.

--------------------------------------------------
Example 1:

Input:
nums = [2,1,4,3,5], k = 10

Output:
6

Explanation:
The valid subarrays are:
[2]      -> (2) × 1 = 2
[1]      -> (1) × 1 = 1
[4]      -> (4) × 1 = 4
[3]      -> (3) × 1 = 3
[5]      -> (5) × 1 = 5
[2,1]    -> (2+1) × 2 = 6

Subarrays such as [1,4] have score:
(1+4) × 2 = 10
which is NOT valid because the score must be strictly less than k.

--------------------------------------------------
Example 2:

Input:
nums = [1,1,1], k = 5

Output:
5

Explanation:
Valid subarrays:
[1], [1], [1], [1,1], [1,1]

The subarray [1,1,1] has score:
(1+1+1) × 3 = 9 > 5

--------------------------------------------------
Constraints:

1 <= nums.length <= 100000
1 <= nums[i] <= 100000
1 <= k <= 10^15

--------------------------------------------------
Approach (Sliding Window):

1. Maintain a sliding window using two pointers:
   - left
   - right

2. Keep track of the current window sum.

3. For every right:
   - Add nums[right] to sum.
   - While:
         sum × windowLength >= k
     shrink the window from the left.

4. After the window becomes valid,
   every subarray ending at right and starting
   between left and right is also valid.

5. Add:
       (right - left + 1)
   to the answer.

--------------------------------------------------
Time Complexity:
O(n)

Space Complexity:
O(1)
*/

public class CountSubarrayWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        long count = 0;

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (left <= right && sum * (right - left + 1L) >= k) {
                sum -= nums[left];
                left++;
            }

            count += (right - left + 1);
            right++;
        }

        return count;

    }

    public static void main(String[] args) {
        CountSubarrayWithScoreLessThanK solution = new CountSubarrayWithScoreLessThanK();
        int[] nums = { 2, 1, 4, 3, 5 };
        long k = 10;
        long ans = solution.countSubarrays(nums, k);
        System.out.println(ans);

    }
}