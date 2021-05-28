package com.linksong.leetcode.dpproject;

/**
 * @author 1625159399@qq.com
 * @date 2021/5/28 20:46
 */
public class LeetCode062 {
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else if (i > 0) {
                    f[i][j] = f[i - 1][j];
                } else if (j > 0) {
                    f[i][j] = f[i][j - 1];
                }

            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int n = uniquePaths(3, 7);
        System.out.println(n);


        /*
        * 结题思路
        *
        * 定义 f[i][j] 为到达位置 (i,j) 的不同路径数量。

        那么 f[n-1][m-1] 就是最终的答案， f[0][0] = 1 为起始条件。

        由于题目限定了我们只能 往下 或者 往右 移动，因此我们按照「当前可选方向」进行分析：

        当前位置只能 「往下」 移动，即有 f[i][j] = f[i-1][j]

        当前位置只能 「往右」 移动，即有 f[i][j] = f[i][j-1]

        当前位置即能 「往下」 也能 「往右」 移动，即有 f[i][j] = f[i][j-1] + f[i-1][j]
        *
        * */
    }
}
