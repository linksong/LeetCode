package com.linksong.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 1625159399@qq.com
 * @date 2021/6/4 22:17
 */
public class Leetcode018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4 || nums == null) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target || nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i + 1]) {
                continue;
            }

            int left = i;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[left + 1] + nums[left + 2] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[left], nums[left + 1], nums[left + 2], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }
            }
        }
        return result;
    }
}
