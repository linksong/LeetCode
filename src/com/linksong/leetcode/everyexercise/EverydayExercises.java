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

    /*
     * 什么是滑动窗口？
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
     * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     *
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     *
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度：O(n)
     *
     * 3. 无重复字符的最长子串
     * 30. 串联所有单词的子串
     * 76. 最小覆盖子串
     * 159. 至多包含两个不同字符的最长子串
     * 209. 长度最小的子数组
     * 239. 滑动窗口最大值
     * 567. 字符串的排列
     * 632. 最小区间
     * 727. 最小窗口子序列
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

}
