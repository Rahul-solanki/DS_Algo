package MrSt;

/*
* Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3] Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4] Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
* */
public class MinimumLengthSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minLength(arr, 1));

        int[] arr1 = {1, 4, 45, 6, 10, 19};
        System.out.println(minLengthApproach(arr1,70));


    }

    static int minLength(int[] arr, final int target) {
        int length = 0;
        for (int j : arr) {
            if (j >= target) {
                return 1;
            }
        }
        for (int i = 0; i <= arr.length - 2; i++) {
            if (arr[i] >= target) {
                return 1;
            }
            if (arr[i] + arr[i + 1] >= target) {
                return 2;
            }
        }
        for (int i = 0; i <= arr.length - 3; i++) {
            if (arr[i] + arr[i + 1] + arr[i + 2] >= target) {
                return 3;
            }
        }
        return length;
    }

    static int minLengthApproach(int[] arr, int target) {
        int n = arr.length;
        int min_length = arr.length + 1;

        for (int start = 0; start < n; start++) {
            int curr_sum = arr[start];
            if (curr_sum > target) {
                return 1;
            }
            for (int end = start + 1; end < n; end++) {
                curr_sum += arr[end];
                if (curr_sum > target && (end - start + 1) < min_length)
                    min_length = (end - start + 1);
            }
        }
        return min_length;
    }
}
