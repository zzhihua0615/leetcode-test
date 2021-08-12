package z.z.h.searchrange;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 示例：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * @author zzhihua
 * @date 2021/8/12
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] resultNums = {-1, -1};
        int length = nums.length;
        if (length == 0) {
            return resultNums;
        }
        for (int i = 0; i < length; i++) {
            if (target < nums[i]) {
                return resultNums;
            }
            if (nums[i] == target) {
                if (resultNums[0] == -1) {
                    resultNums[0] = i;
                }
                resultNums[1] = i;
            }
        }
        return resultNums;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 思路：采用二分法
     * 直观的思路肯定是从前往后遍历一遍。用两个变量记录第一次和最后一次遇见 target\textit{target}target 的下标，但这个方法的时间复杂度为 O(n)O(n)O(n)，没有利用到数组升序排列的条件
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
