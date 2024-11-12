import java.util.*;

/*  Bruteforce approach - Time Complexity : O(n^2)   */
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        int i, j, n = nums.length;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}

/* Better Approach - Time Complexity :O(N) */
class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        int i, n = nums.length;
        Arrays.sort(nums);
        for (i = 1; i < n; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }
}

/* optimal Approach - Time Complexity :O(N) */
class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        int i, n = nums.length;
        HashSet<Integer> set = new HashSet();
        for (i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        if (set.size() < n)
            return true;
        return false;
    }
}
