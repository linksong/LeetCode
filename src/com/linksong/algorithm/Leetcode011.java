package com.linksong.algorithm;

/**
 * @author 1625159399@qq.com
 * @date 2021/6/9 20:28
 */
public class Leetcode011 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int result = 0;
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
}
