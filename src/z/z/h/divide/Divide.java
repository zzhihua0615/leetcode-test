package z.z.h.divide;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zzhihua
 * @date 2021/7/26
 */
public class Divide {

    public static int result = 0;

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    /**
     * 总体思路：乘除法的实际其实是加减，通过加减+递归的方式得出结果
     * 该方法会产生java.lang.StackOverflowError，但是总体思路应该是正确的
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return result;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        if (divisor == 0) {
            throw new RuntimeException("zero can`t be divisor");
        }
        if (dividend > 0 && divisor > 0) {
            if (dividend < divisor) {
                return result;
            }
            result++;
            return divide(dividend - divisor, divisor);
        } else if (dividend < 0 && divisor < 0) {
            if (dividend > divisor) {
                return result;
            }
            result++;
            return divide(dividend - divisor, divisor);
        } else if (dividend > 0 && divisor < 0) {
            if (dividend + divisor < 0) {
                return result;
            }
            result--;
            return divide(dividend + divisor, divisor);
        } else {
            if (dividend + divisor > 0) {
                return result;
            }
            result--;
            return divide(dividend + divisor, divisor);
        }
    }

    /**
     * 该方法与上面方法类似，当时每次加减的被除数逐渐递增，提高效率
     * 作者：liujin - 4
     * 链接：https:
     * //leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @return
     */
    public int divide2(int dividend, int divisor) { // 被除数 除数
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            // 溢出
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[2^31, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        if (a > b) {
            return 0;
        }
        int ans = div(a, b);
        return sign == -1 ? -ans : ans;
    }

    int div(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int tb = b;
        // 溢出之后不再小于0
        while (tb + tb >= a && tb + tb < 0) {
            tb += tb;
            count += count;
        }
        return count + div(a - tb, b);
    }
}
