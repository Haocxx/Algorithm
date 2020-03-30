package base;

public class QuickSort {
    public static void main(String[] args) {
        int[] values = new int[] {3,123,124,6,4,7,8,23,4,1,-1};
        sort(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    public static void sort(int[] values) {
        sort(values, 0, values.length - 1);
    }

    private static void sort(int[] values, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        int value = values[r];
        while (left < right) {
            while (left < right && values[left] <= value) {
                left++;
            }
            while (left < right && values[right] >= value) {
                right--;
            }
            if (left < right) {
                int temp = values[left];
                values[left] = values[right];
                values[right] = temp;
                left++;
                right--;
            }
        }
        if (left == right) {
            values[r] = values[left];
            values[left] = value;
            sort(values, l, left - 1);
            sort(values, left + 1, r);
        }
    }
}
