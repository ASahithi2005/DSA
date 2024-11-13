// Time Complexity - O(N) 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i, n = nums.length;
        int[] product = new int[n];
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i];
        }
        return product;
    }
}
