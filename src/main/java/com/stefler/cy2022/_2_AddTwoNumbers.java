package com.stefler.cy2022;

import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _2_AddTwoNumbers {


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

        ListNode(List<Integer> list) {
            Integer num = list.get(0);
            if (list.size() > 1) {
                List<Integer> newList = list.subList(1, list.size());
                this.val = num;
                this.next = new ListNode(newList);
            } else {
                this.val = num;
            }
        }

        @Override
        public String toString() {
            return this.val + (this.next == null ? "" : "," + this.next);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers1(l1, l2, 0);
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2, int jinwei) {
        if (l1 == null && l2 == null) {
            if (jinwei == 0) {
                return null;
            } else {
                return new ListNode(jinwei);
            }
        }
        int current = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + jinwei;
        return new ListNode(current % 10, addTwoNumbers1(l1 == null ? null : l1.next, l2 == null ? null : l2.next, current / 10));
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(Arrays.asList(9,9,9,9,9,9,9)), new ListNode(Arrays.asList(9,9,9,9))));
    }

}
