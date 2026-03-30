/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return usingFastPointer(head, n);
        // int count = 0;
        // ListNode tmp = head;
        // while(tmp != null) {
        //     count++;
        //     tmp = tmp.next;
        // }

        // int index = count - n-1;
        // tmp = head;
        // while(index != 0 && tmp != null) {
        //     tmp = tmp.next;
        //     index--;
        // }
        // if(count - n == 0) return head.next;
        // tmp.next = tmp.next.next;
        // return head;

    }

    public ListNode usingFastPointer(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n ; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}


