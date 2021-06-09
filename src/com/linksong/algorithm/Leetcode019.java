package com.linksong.algorithm;

/**
 * @author 1625159399@qq.com
 * @date 2021/6/9 20:37
 */
public class Leetcode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
}
