package com.linksong.leetcode.dpprolect;

/**
 * @author 1625159399@qq.com
 * @date 2021/5/30 15:27
 */
public class Leetcode005 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int sLength = s.length();
        int subStrLength = 0;
        int subStrBegin = 0;
        //dp[i][l] 表示s从i到l为回文串
        boolean[][] dp = new boolean[sLength][sLength];
        for (int r = 0; r < sLength; r++) {
            for (int l = 0; l < sLength; l++) {
                while (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > subStrLength) {
                        subStrBegin = l;
                        subStrLength = l - r + 1;
                    }
                }
            }
        }
        return s.substring(subStrBegin, subStrBegin + subStrLength);
    }


    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome01(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        int left = 0;
        int right = 0;
        //窗口大小
        int len = 1;
        int subStrLength = 0;
        int subStrBegin = 0;

        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;
            while (left > 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < length && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > subStrLength) {
                subStrLength = len;
                subStrBegin = left;
            }
            len = 1;
        }
        return s.substring(subStrBegin + 1, subStrBegin + subStrLength + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome01("aba"));
    }
}
