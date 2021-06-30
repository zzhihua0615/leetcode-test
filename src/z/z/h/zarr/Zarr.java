package z.z.h.zarr;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class Zarr {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
//        String s = "ABCDE";
//        System.out.println(convert(s, 2));
        System.out.println(convert(s, 5));

    }

    /**
     * 暴力破解，先确定数组有多少行多少列，再将字符设置到相应的位置，最后整合成字符串
     * 一个完整的周期有2n-2个元素
     * 一个完整的周期有n-1列
     * 第一行的元素下标为2n-2
     * 最后一行的元素下标为3n-3
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int length = s.length();
        int column = 0;
        //求有多少完整周期
        int cycle = length / (2 * numRows - 2);
        //求额外剩余的元素个数
        int rem = length % (2 * numRows - 2);
        column = cycle * (numRows - 1) == 0 ? 1 : cycle * (numRows - 1);
        if (rem > 0) {
            if (rem > numRows) {
                column = column + rem - numRows + 1;
            } else {
                column = column + 1;
            }
        }
        //如何为二维数组赋值，在于指针怎么走
        //如果在前n个元素内，指针只移动y轴，即（x+1，y）
        //如果在（n，2n-2）个元素内，则每次赋值x轴和y轴各移动一次，即（x-1，y+1）
        //每个周期内的在同一列的元素的范围时[2n-2,3n-3]，即每个周期的起始位置时cycle*(2n-2)
        int x = 0;
        int y = 0;
        int currentCyc = 0;
        Character[][] sArr = new Character[numRows][column];
        for (int i = 0; i < length; i++) {
            sArr[x][y] = s.charAt(i);
            currentCyc = i / (2 * numRows - 2);
            if (i >= currentCyc * 2 * (numRows - 1) && i < currentCyc * 2 * (numRows - 1) + (numRows - 1)) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                if (sArr[i][j] != null) {
                    sb.append(sArr[i][j]);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 方法二：不需要关系元素所在的具体位置，只需要关注元素所在哪一行，以及添加的方向
     * 因为最后返回结果的时候并不需要关系元素中空出来的位置，只需要关系字符串
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 方法三：直接判断字符串中的各个元素应该属于哪一行
     * 行0中的字符位于索引k(2n-2)处
     * 行n-1中的字符位于索引k(2n-2)+n-1处
     * 内部的行i中的字符位于索引k(2n-2)+i以及(k+1)(2n-2)-i处
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert3(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
