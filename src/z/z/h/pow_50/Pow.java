package z.z.h.pow_50;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x`n ）。
 *
 * @author zzhihua
 * @date 2022/2/9
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }

    /**
     * 方法一：暴力破解，但是这种方式在部分验证项情况下存在误差，无法通过
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        int i = 0;
        double result = 1;
        if (n > 0) {
            while (i < n) {
                result = result * x;
                i++;
            }
        } else {
            while (i < n) {
                result = result / (-x);
                i++;
            }
        }
        return result;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 思路：第二种方法：快速幂+递归
     * 快速幂的思想就是原先将X的4次幂转未X·2 和X·2相乘将原先的四次计算缩短为两次计算，节省了时间
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 方法三：快速幂+迭代
     * 递归需要使用额外的栈空间
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul2(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
