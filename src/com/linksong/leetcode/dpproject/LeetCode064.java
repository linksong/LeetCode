package com.linksong.leetcode.dpproject;

/**
 * @author 1625159399@qq.com
 * @date 2021/5/28 20:46
 */
public class LeetCode064 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = obstacleGrid[i][j];
                } else {
                    int top = i - 1 >= 0 ? f[i - 1][j] + obstacleGrid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? f[i][j - 1] + obstacleGrid[i][j] : Integer.MAX_VALUE;
                    f[i][j] = Math.min(top, left);
                }
            }

        }
        return f[m - 1][n - 1];
    }


}
