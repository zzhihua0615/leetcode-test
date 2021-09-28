package z.z.h.countandsay;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zzhihua
 * @date 2021/9/23
 */
public class CountAndSay {

    /**
     * 解题思路：
     * 对于计算字符串中每个数字出现的个数，使用双指针i, j，其中i表示当前字符，j则是计数指针，向后移动判断；
     * 以求n = 5，lastStr = countAndSay(4) = "1211"为例，answer = ""，一开始让i = 0, j = 1，此时'1' != '2'，
     * 故answer += (j - i) + lastStr.charAt(i)，ans = "11"；然后让i = j（第二个不同字符起始位置），
     * 然后j++往后移动；此时i = j = 1，j = j + 1 = 2，又'2' != '1'，
     * 所以answer += (j - i) + lastStr.charAt(i),ans = "1112",重复i = j = 2， j = ++j = 3；此时'1' = '1'；
     * 故直接j = ++j = 4 == lastStr.length()，所以跳出循环，然后把最后一次的字符个数字符加上，即执行：
     * answer += (j - i) + lastStr.charAt(i),ans = "111221"，即countAndSay(5) = "111221"。
     * <p>
     * 作者：struggle - mws
     * 链接：https:
     * //leetcode-cn.com/problems/count-and-say/solution/1msdi-gui-fa-jian-dan-hao-li-jie-by-stru-nv96/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String lastStr = countAndSay(n - 1);
            StringBuilder ans = new StringBuilder();
            int i = 0, j = 1, len = lastStr.length();
            while (j < len) {
                if (lastStr.charAt(i) != lastStr.charAt(j)) {
                    ans.append(j - i).append(lastStr.charAt(i));
                    i = j;
                }
                j++;
            }
            ans.append(j - i).append(lastStr.charAt(i));
            return ans.toString();
        }
    }

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        } else {
            String lastCountAndSay = countAndSay2(n - 1);
            StringBuilder sBuffer = new StringBuilder();
            int i = 0;
            int j = 1;
            while (j < lastCountAndSay.length()) {
                //对当前字符进行计数
                if (lastCountAndSay.charAt(i) != lastCountAndSay.charAt(j)) {
                    //直到两个字符不一致，他们中间的距离表示该字符出现的次数，（j-i）次lastCountAndSay.charAt(i)
                    sBuffer.append(j - i).append(lastCountAndSay.charAt(i));
                    //i移动到下一个要统计的字符上
                    i = j;
                }
                j++;
            }
            //遍历完要补充，最后一个字符出现的次数，前面循环没有统计
            sBuffer.append(j - i).append(lastCountAndSay.charAt(i));
            return sBuffer.toString();
        }
    }
}