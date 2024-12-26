//Brute force approach
//Time complexity: O(N)
class Solution1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

// optimal Approach
// Time complexity: O(logN)
class Solution2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
