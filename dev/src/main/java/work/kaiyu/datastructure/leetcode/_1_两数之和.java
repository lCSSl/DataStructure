package work.kaiyu.datastructure.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cssly
 * @date: 2021/3/12 1:24
 * @description:
 * @url: https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tables = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (tables.containsKey(target - nums[i])) {
                return new int[]{tables.get(target - nums[i]), i};
            }
            tables.put(nums[i], i);
        }
        return new int[0];
    }
}
