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

    /**
     * 当我们对数组 digits 加一时，我们只需要关注 digits 的末尾出现了多少个 9 即可。我们可以考虑如下的三种情况：
     * <p>
     * 如果 digits 的末尾没有 9，例如 [1,2,3]，那么我们直接将末尾的数加一，得到 [1,2,4] 并返回；
     * <p>
     * 如果 digits 的末尾有若干个 9，例如 [1,2,3,9,9]，那么我们只需要找出从末尾开始的第一个不为 9 的元素，即 3，将该元素加一，得到 [1,2,4,9,9]。随后将末尾的 9 全部置零，得到 [1,2,4,0,0] 并返回。
     * <p>
     * 如果 digits 的所有元素都是 9，例如 [9,9,9,9,9]，那么答案为 [1,0,0,0,0,0]。我们只需要构造一个长度比 digits 多 1 的新数组，将首元素置为 1，其余元素置为 0 即可。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/plus-one/solution/jia-yi-by-leetcode-solution-2hor/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
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
