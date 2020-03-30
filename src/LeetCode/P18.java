package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P18 {
    public static void main(String[] s) {
        new P18().fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1;
                int d = nums.length - 1;
                if (c >= d) {
                    continue;
                }
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        result.add(list);
                        d--;
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                        c++;
                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                    } else if (sum > target) {
                        d--;
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                    } else {
                        c++;
                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
