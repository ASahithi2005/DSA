
/* kadane's Algorithm - Maximum Sub array /
/*  Bruteforce approach - Time Complexity : O(n^3)   */
class Solution1 {
    public int maxSubArray(int[] nums) {
        int i, j, k, n = nums.length;
        int max = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                int sum = 0;
                for (k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }

        }
        return max;
    }
}

/* Better Approach - Time Complexity :O(N^2) */
class Solution2 {
    public int maxSubArray(int[] nums) {
        int i, j, k, n = nums.length;
        int max = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            int sum = 0;
            for (j = i; j < n; j++) {
                sum += nums[j];

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

/* optimal Approach - Time Complexity :O(N) */
class Solution {
    public int maxSubArray(int[] nums) {
        int i, j, k, n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
