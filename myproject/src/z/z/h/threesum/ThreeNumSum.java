package z.z.h.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzhihua
 * @date 2021/4/25
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeNumSum(nums));
    }

    public static List<List<Integer>> threeNumSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int first = 0;
        int second = 1;
        int third = 2;
        int index = third;
        List<List<Integer>> result = new ArrayList<>();
        while (index < nums.length) {
            if (nums[first] + nums[second] + nums[third] > 0) {
                
            }
            if (nums[first] + nums[second] + nums[third] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[first]);
                list.add(nums[second]);
                list.add(nums[third]);
                result.add(list);
            }
            if (third < nums.length - 1) {
                third++;
            } else if (third == nums.length - 1) {
                first++;
                second++;
                index++;
            }
            if (first == nums.length - 3) {
                break;
            }

        }
        return result;
    }
}
