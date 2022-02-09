package z.z.h.maxsubarray_51;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 *
 * @author zzhihua
 * @date 2022/2/9
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(num));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return -1;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                break;
            }
            max = compare(nums, i, max);
        }
        return max;
    }

    public static int compare(int[] nums, int index, int max) {
        int sum = 0;
        while (index < nums.length) {
            sum += nums[index];
            if (sum > max) {
                max = sum;
            }
            index++;
        }
        return max;
    }

    /**
     * 方法一：动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
