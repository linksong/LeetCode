package com.linksong.leetcode.dpproject;

/**
 * @author 1625159399@qq.com
 * @date 2021/5/31 21:21
 */
public class Leetcode931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        // 枚举首行的每个下标作为「起点」
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, find(matrix, i));
        }
        return ans;
    }

    //返回以 (0, u) 作为起点的最小路径和
    int find(int[][] mat, int u) {
        int n = mat.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = i == u ? mat[0][i] : Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                int val = mat[i][j];
                if (f[i - 1][j] != Integer.MAX_VALUE) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
                }
                if (j - 1 >= 0 && f[i - 1][j - 1] != Integer.MAX_VALUE) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                }
                if (j + 1 < n && f[i - 1][j + 1] != Integer.MAX_VALUE) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j + 1] + val);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n - 1][i]);
        }
        return ans;
    }
}
