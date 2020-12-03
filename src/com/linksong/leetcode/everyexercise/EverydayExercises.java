package com.linksong.leetcode.everyexercise;

import com.linksong.leetcode.util.ListNode;

import java.util.HashMap;

public class EverydayExercises {

    /*
     * LeetCoede 2 两数相加
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * */

    //小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
    // 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = null;
        ListNode tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;

            if (header == null) {
                header = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return header;
    }


    /*
     *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  Leetcode 3
     *
     * */


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    /*
    *
    * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    *
    * LeetCode 5
    *
    * 动态规划题目，仍需思考、练习
    * */
    public String longestPalindrome(String s) {
        String longPalindrome = null;


        return longPalindrome;
    }

}
