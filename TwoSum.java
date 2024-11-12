import java.util.HashMap;

/*Brute Force Approach
   Time Complexity : O(n^2) */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int i, j;
        int[] arr = new int[2];
        int n = nums.length;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {

                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}

/*
 * optimal approach
 * Time Complexity : O(n)
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int i, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res[0] = map.get(complement);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}