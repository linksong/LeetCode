package com.linksong.leetcode.dpproject;

import java.util.List;

/**
 * @author 1625159399@qq.com
 * @date 2021/5/31 21:56
 */
public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {

                dp[i][j] =Integer.MAX_VALUE;
                if (j != 0) {
                    dp[i][j] = Math.min( dp[i][j],dp[i - 1][j - 1] + triangle.get(i).get(j));
                }
                if (j != i) {
                    dp[i][j] = Math.min( dp[i][j],dp[i - 1][j] + triangle.get(i).get(j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.min(dp[n - 1][i], ans);
        }
        return ans;
    }
}
