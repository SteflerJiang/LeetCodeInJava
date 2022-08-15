package com.stefler.cy2022;

import java.util.HashMap;
import java.util.Map;

public class _19RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        int cnt = 1;
        ListNode tmp = head;
        while (tmp != null) {
            map.put(cnt++, tmp);
            tmp = tmp.next;
        }
        int size = map.size();
        if (size == n) {
            return head.next;
        } else {
            ListNode node = map.get(size-n);
            node.next = node.next.next;
        }
        return head;
    }


      static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(null, 0 ));
    }

}
