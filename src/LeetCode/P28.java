package LeetCode;

/**
 * start: 20:23
 * finish: 20:33
 */
public class P28 {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        int needleLength = needle.length();
        int haystackLength = haystack.length();
        if (needleLength > haystackLength) {
            return -1;
        }

        int index = 0;
        for (;;) {
            if (index >= haystackLength) {
                break;
            }
            if (needleLength > haystackLength - index) {
                break;
            }
            boolean result = true;
            for (int i = 0; i < needleLength; i++) {
                if (haystack.charAt(index + i) != needle.charAt(i)) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return index;
            }
            index++;
        }

        return -1;
    }
}
