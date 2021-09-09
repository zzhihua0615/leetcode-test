package z.z.h.searchInsert;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * @author zzhihua
 * @date 2021/9/9
 */
public class SearchInsert {

    /**
     * 方法一，怎么土怎么来，中心思路还是采用二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }
        if (nums[right] < target) {
            return right + 1;
        }
        if (nums[left] > target) {
            return 0;
        }
        while (left < right) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            int index = (left + right) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] > target) {
                if (nums[index] > target && nums[index - 1] < target) {
                    return index;
                }
                right = index;
            }
            if (nums[index] < target) {
                if (nums[index] < target && nums[index + 1] > target) {
                    return index + 1;
                }
                left = index;
            }
        }
        return left;
    }


    /**
     * 标准的二分法
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/search-insert-position/solution/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }
}
