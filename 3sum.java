
//Bruteforce Approach
//Time complexity: O(N^3 * log(no. of unique triplets))
import java.util.*;

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ss = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        ss.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ll = new ArrayList<>(ss);
        return ll;

    }
}

// Better approach
// Time complexity : O(N^2 * log(no. of unique triplets)) , Space Complexity :
// O(2 * no. of the unique triplets) + O(N)
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ss = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hs = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (hs.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    ss.add(temp);
                }
                hs.add(nums[j]);

            }
        }
        List<List<Integer>> ll = new ArrayList<>(ss);
        return ll;

    }
}

// Optimal Appraoch
// Time complexity: O(NlogN)+O(N^2) , Space Complexity : O(1)
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;

    }
}
