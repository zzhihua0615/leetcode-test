package z.z.h.palinedrome;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalineDrome {
    public static void main(String[] args) {
        int x = 121;
//        System.out.println(x % 10);
//        System.out.println(x / 10);
        System.out.println(isPalindrome(x));
    }

    /**
     * 方法一：直接将整个数字反转，判断反转前后数字是否一致
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int original = x;
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int rev = 0;
        while (x > 0) {
            int rem = x % 10;
            if (rev > Integer.MAX_VALUE / 10 && rem > 7) {
                return false;
            }
            rev = 10 * rev + rem;
            x /= 10;
        }
        if (rev == original) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 方法二：只反转数字的一半
     * 上述方法一需要额外处理整数溢出的问题
     * 如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同
     * 在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
     * <p>
     * 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
