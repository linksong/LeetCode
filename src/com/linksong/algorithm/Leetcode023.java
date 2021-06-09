package com.linksong.algorithm;

/**
 * @author 1625159399@qq.com
 * @date 2021/6/9 20:10
 */
public class Leetcode023 {
    /*
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * */


    /**
     * 方法 1：顺序合并
     * <p>
     * 时间复杂度 O(nk^2)
     * 空间复杂度 O(1)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (int i = 0; i < lists.length; i++) {
            listNode = mergeTwoLists(lists[i], listNode);
        }
        return listNode;
    }

    /**
     * 方法2：分治合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    /**
     * 合并两个有序链表
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode listNode = new ListNode(-1);
        ListNode tail = listNode, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return listNode.next;
    }


}