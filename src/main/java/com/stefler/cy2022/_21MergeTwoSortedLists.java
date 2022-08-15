package com.stefler.cy2022;

public class _21MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return null;
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
