package z.z.h.groupanagrams;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。(即出现相同字母的单词)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zzhihua
 * @date 2021/12/28
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 方法一：主要思路是判断使用的单词是否相同，可以参考String的hashCode方法设计一个确保出现单词一致的方法
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> groupAnagrams = new HashMap<>();
        for (String str : strs) {
            int hashCode = newHashCode(str);
            List<String> list = groupAnagrams.get(hashCode);
            if (list == null || list.size() <= 0) {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                groupAnagrams.put(hashCode, stringList);
            } else {
                list.add(str);
            }
        }
        List<List<String>> resultList = new ArrayList<>();
        if (groupAnagrams != null) {
            groupAnagrams.keySet().forEach(item -> {
                resultList.add(groupAnagrams.get(item));
            });
        }
        return resultList;
    }

    /**
     * 方法二：由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private static int newHashCode(String str) {
        int hashCode = 0;
        int hash = 31;
        for (char c : str.toCharArray()) {
            hashCode = hashCode + (hash * c);
        }
        return hashCode;
    }

}
