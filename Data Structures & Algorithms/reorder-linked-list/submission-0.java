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
    public void reorderList(ListNode head) {
        if(head == null) return;
        if(head.next == null || head.next.next == null) {
            return ;
        }
        ListNode slow = head;
        ListNode fast = head;
        //Find the midpoint
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the sencond half of the list
        ListNode prevptr = null;
        ListNode currptr = slow.next;
        slow.next = null;
        while(currptr != null) {
            ListNode nextptr = currptr.next;
            currptr.next = prevptr;
            prevptr = currptr;
            currptr = nextptr;
        }
      

        slow = head;
        while(slow != null && prevptr != null) {
            ListNode tmp = prevptr;
            prevptr = prevptr.next;
            ListNode tmp2 = slow.next;
            slow.next = tmp;
            tmp.next = tmp2;
            slow = tmp2;
        }


    }
}
