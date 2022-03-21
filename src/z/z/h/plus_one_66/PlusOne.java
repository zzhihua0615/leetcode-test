package z.z.h.plus_one_66;

/**
 * @author zzhihua
 * @date 2022/3/21
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println(plusOne(digits).toString());
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
