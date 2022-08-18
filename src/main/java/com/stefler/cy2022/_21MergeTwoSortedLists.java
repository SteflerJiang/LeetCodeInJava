package com.stefler.cy2022;

public class _21MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode start = null;
        ListNode head = null;
        while (tmp1 != null && tmp2 != null) {
            if (start == null) {
                start = new ListNode();
                head = start;
            } else {
                start.next = new ListNode();
                start = start.next;
            }

            if (tmp1.val <= tmp2.val) {
                start.val = tmp1.val;
                tmp1 = tmp1.next;
            } else {
                start.val = tmp2.val;
                ;
                tmp2 = tmp2.next;
            }
        }

        start.next = tmp1 == null ? tmp2 : tmp1;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(null, null));
    }
}
