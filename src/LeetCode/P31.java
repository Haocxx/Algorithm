package LeetCode;

/**
 * start: 21:14
 * end: 21:45
 */
public class P31 {
    public static void main(String[] args) {
        int[] num = new int[] {3,2,1};
        new P31().nextPermutation(num);
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            int pre = nums[i];
            if (i + 1 >= nums.length) {
                continue;
            }
            int minIndex= i + 1;
            int min = nums[minIndex];
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j] && nums[j] > pre) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (pre < min) {
                nums[i] = min;
                nums[minIndex] = pre;

                for (int m = i + 1; m < nums.length; m++) {
                    for (int n = m + 1; n < nums.length; n++) {
                        if (nums[m] > nums[n]) {
                            int temp = nums[m];
                            nums[m] = nums[n];
                            nums[n] = temp;
                        }
                    }
                }

                return;
            }
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
    }
}
