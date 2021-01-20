package work.kaiyu.datastructure.list;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;

@Slf4j
public class Solution {

    public static int search(int[] nums, int target) {
//        int count=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==target)
//                count++;
//        }
//        return count;
        Arrays.sort(nums);
        return helper(nums, target) - helper(nums, target - 1);
    }

    /**
     * 二分
     *
     * @param nums
     * @param target
     * @return
     */
    private static int helper(int nums[], int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    private static int max = 21;
    // 经常需要用到的数据
    private static int[] targets = new int[max + 1];

    // 静态代码块初始化数组, 随着类的加载而执行，而且只执行一次
    static {
        targets[0] = 1;
        for (int i = 1; i <= max; i++) {
            targets[i] = 2 << (i - 1);
        }
    }

    public static int countPairs(int[] deliciousness) {
        int min, max;
        min = max = deliciousness[0];
        for (int v : deliciousness) {
            if (v < min) {
                min = v;
            } else if (v > max) {
                max = v;
            }
        }
        int[] map = new int[max - min + 1];
        long res = 0;
        LinkedList<String> linkedList = new LinkedList<>();
        for (int v : deliciousness) {
            for (int s = 1; ; s <<= 1) {
                int x = s - v;
                if (x < min) {
                    continue;
                }
                if (x > max) {
                    break;
                }
                res += map[x - min];
            }
            map[v - min]++;
        }
        return (int) (res % 1_000_000_007L);
    }

}
