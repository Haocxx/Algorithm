package LeetCode;

/**
 * start: 14:59
 * finish: 15:20
 */
public class P34 {
    public static void main(String[] args) {
        P34 p34 = new P34();
        int[] result = p34.searchRange(new int[] {5,7,7,8,8,10}, 6);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = 1;
        if (nums.length == 0) {
            return new int[]{left, right};
        }
        int findPos = find(nums, target, 0, nums.length - 1);
        if (findPos >= 0) {
            left = findPos;
            right = findPos;
            while (left > 0) {
                if (nums[left - 1] == target) {
                    left--;
                } else {
                    break;
                }
            }
            while (right < nums.length - 1) {
                if (nums[right + 1] == target) {
                    right++;
                } else {
                    break;
                }
            }
        }
        return new int[]{left, right};
    }

    public int find(int[] nums, int target, int start, int end) {
        if (nums[start] > target || nums[end] < target) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        if (end - start <= 1) {
            return -1;
        }
        if (nums[(start + end) / 2] > target) {
            return find(nums, target, start, (start + end) / 2);
        } else {
            return find(nums, target,(start + end) / 2, end);
        }
    }
}
