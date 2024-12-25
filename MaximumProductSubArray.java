// Brute Force approach 
//Time Complexity : O(N^2)
class Solution1 {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }
}

/*
 * optimal solution
 * Time Complexity: O(N)
 * 
 * observation of problem
 * all positive numbers in array-max product will be product of all numbers
 * even negavite numbers-max product is product of all numbers
 * odd negative numbers - comparing prefix max product and suffix max product
 * any zeroes in array - prefix and suffix are reset to 1
 */
class Solution2 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));

        }
        return max;
    }
}