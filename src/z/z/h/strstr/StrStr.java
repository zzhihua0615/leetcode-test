package z.z.h.strstr;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * @author zzhihua
 * @date 2021/7/12
 */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 解题思路：参考indexOf方法，先获得haystack和needle首字符相同的位置下标，再从该位置开始逐个比较字符是否相等
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (null == needle || needle.trim().length() == 0) {
            return 0;
        }
        char[] needleCharArr = needle.toCharArray();
        char[] chars = haystack.toCharArray();
        char first = needleCharArr[0];
        int max = chars.length - needleCharArr.length;
        for (int i = 0; i <= max; i++) {
            if (first != chars[i]) {
                continue;
            }
            if (needleCharArr.length == 1) {
                return i;
            }
            int j = i + 1;
            for (int k = 1; j < chars.length && chars[j] == needleCharArr[k]; j++, k++) {
                if (k == needleCharArr.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
