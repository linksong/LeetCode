package com.linksong.algorithm;

/**
 * @author 1625159399@qq.com
 * @date 2021/6/10 21:49
 */
public class Leetcode024 {

    /**
     * 递归解法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 非递归解法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

}
