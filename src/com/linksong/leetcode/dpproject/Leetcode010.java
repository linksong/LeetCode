package com.linksong.leetcode.dpproject;

/**
 * @author 1625159399@qq.com
 * @date 2021/6/1 21:52
 */
public class Leetcode010 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        s = " " + s;
        p = " " + p;
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        /*
        * dp(i,j) 代表考虑 s 中以 i 为结尾的子串和 p 中的 j 为结尾的子串是否匹配。即最终我们要求的结果为 dp[n][m] 。
        *
        * */
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 <= m && pArray[j + 1] == '*') {
                    continue;
                }

                // 对应了 p[j] 为普通字符和 '.' 的两种情况
                if (i - 1 >= 0 && pArray[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (sArray[i] == pArray[j] || pArray[j] == '.');
                }

                // 对应了 p[j] 为 '*' 的情况
                else if (pArray[j] == '*') {
                    dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) || (i - 1 >= 0 && dp[i - 1][j] && (sArray[i] == pArray[j - 1] || pArray[j - 1] == '.'));
                }

            }
        }
        return dp[n][m];
    }
}
