/*
You are given an array arr[] of integers. Find the total count of subarrays with their sum equal to 0.

Examples:

Input: arr[] = [0, 0, 5, 5, 0, 0]
Output: 6
Explanation: The 6 subarrays are [0], [0], [0], [0], [0,0], and [0,0].

Input: arr[] = [6, -1, -3, 4, -2, 2, 4, 6, -12, -7]
Output: 4
Explanation: The 4 subarrays are [-1, -3, 4], [-2, 2], [2, 4, 6, -12], 
and [-1, -3, 4, -2, 2]

Input: arr[] = [0]
Output: 1
Explanation: The only subarray is [0].

Constraints:    
1 <= n <= 10^6
-10^9 <= arr[ i ] <= 10^9
*/

import java.util.HashMap;

public class ZeroSumSubarrays {
    public int findSubarray(int[] arr) {

        // code here
        // brute
        // int n = arr.length;
        // int total = 0;
        // for (int i = 0 ; i < n ; i++) {
        // for (int j = i ; j < n ; j++) {
        // int sum = 0;
        // for (int k = i ; k <=j ; k++) {
        // sum += arr[k];

        // }
        // if (sum == 0) {
        // total = total + 1;
        // }
        // }
        // }

        // return total;

        // better
        // int n = arr.length;
        // int total = 0;

        // for (int i = 0; i < n; i++) {
        // int sum = 0;

        // for (int j = i; j < n; j++) {
        // sum += arr[j];
        // if (sum == 0) {
        // total++;
        // }
        // }
        // }

        // return total;

        HashMap<Integer, Integer> map = new HashMap<>();
        // edge case 
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;

    }

    public static void main(String[] args) {
        ZeroSumSubarrays solution = new ZeroSumSubarrays();
        int[] arr = { 0, 0, 5, 5, 0, 0 };
        int ans = solution.findSubarray(arr);
        System.out.println(ans);

    }
}