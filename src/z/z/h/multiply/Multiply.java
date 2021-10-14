package z.z.h.multiply;

import java.util.Objects;

/**
 * @author zzhihua
 * @date 2021/10/13
 */
public class Multiply {

    public static final String ZERO = "0";

    public static void main(String[] args) {
//        System.out.println('9' - '0');
//        System.out.println(Math.pow(10D, 1));
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply2(num1, num2));
    }

    /**
     * 无效的方法，得出的结果不正确，存在精度超出的问题
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (Objects.equals(num1, ZERO) || Objects.equals(num2, ZERO)) {
            return "0";
        }
        Integer num1Value = 0;
        Integer num2Value = 0;
        char[] chars1 = num1.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            int value = chars1[i] - '0';
            if ((chars1.length - i - 1) == 0) {
                num1Value += value;
            } else {
                num1Value += (value * (int) (Math.pow(10D, chars1.length - i - 1)));
            }
        }
        char[] chars2 = num2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            int value = chars2[i] - '0';
            if ((chars2.length - i - 1) == 0) {
                num2Value += value;
            } else {
                num2Value += (value * (int) (Math.pow(10D, chars2.length - i - 1)));
            }
        }
        int i = num1Value / 10000;
        int j = num2Value / 10000;
        int k = i * j;
        if (k < 0) {
            return ("" + k).replace("0.", "");
        } else {
            return ("" + k).replace(".", "");
        }
    }

    /**
     * 方法一：做加法：从右往左遍历乘数，将乘数的每一位与被乘数相乘得到对应的结果，再将每次得到的结果累加
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/multiply-strings/solution/zi-fu-chuan-xiang-cheng-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    /**
     * 方法二：做乘法：
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}
