package z.z.h.longestpre;

/**
 * @author zzhihua
 * @date 2021/4/23
 */
public class LongestPre {

    public static void main(String[] args) {
        String[] strs = {"flower", "flower", "flower", "flower"};
        System.out.println(longestPre(strs));
    }

    public static String longestPre(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String pre = "";
        int i = 1;
        while (i <= strs[0].length()) {
            pre = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (i > strs[j].length() || !strs[j].startsWith(pre)) {
                    if (pre.length() == 1) {
                        return "";
                    }
                    return pre.substring(0, i - 1);
                }
            }
            i++;
        }
        return pre;
    }
}

/**
 * 方法二：依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
 * 每次比较获得两个字符串的重复部分，如果还没比对完数组中的元素重复部分已经为空则直接返回空串。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}

/**
 * 方法三：分治
 * 将一个大的数组分割成两个小数组，分别求得两个数组的最长子串，再将这两个子串进行对比
 */
class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }
}

/**
 * 方法四：二分法
 * 显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。
 * 用 minLength\textit{minLength}minLength 表示字符串数组中的最短字符串的长度，
 * 则可以在 [0,minLength][0,\textit{minLength}][0,minLength] 的范围内通过二分查找得到最长公共前缀的长度。
 * 每次取查找范围的中间值 mid\textit{mid}mid，判断每个字符串的长度为 mid\textit{mid}mid 的前缀是否相同，
 * 如果相同则最长公共前缀的长度一定大于或等于 mid\textit{mid}mid，
 * 如果不相同则最长公共前缀的长度一定小于 mid\textit{mid}mid，
 * 通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
 * <p>
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 通俗理解：将字符串利用二分法拆分 比如 leetcode 氛围leet 和 code 两部分
 * 如果leet部分全匹配，则再用 leet + co（即code的二分法结果）进行匹配，依次类推
 * 同理，如果leet部分不匹配 则使用 le 进行匹配
 */
class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
