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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        reverse(dummy, head, k);
        return dummy.next;

    }
    public void reverse(ListNode leftPtr, ListNode head, int k) {
        int count = 1;
        ListNode ptr = head;
        while(count != k && ptr != null) {
            count++;
            ptr = ptr.next;
        }
        ListNode currPtr = head;
        if(ptr == null) return ;
        ListNode prevPtr = null;
        ListNode nextPtr = null;
        for(int i = 1; i <=k; i++) {
            nextPtr = currPtr.next;
            currPtr.next = prevPtr;
            prevPtr = currPtr;
            currPtr = nextPtr;
        }
        ListNode nextPrevPtr = leftPtr.next;
        leftPtr.next.next = nextPtr;
        leftPtr.next = prevPtr;
        reverse(nextPrevPtr, nextPtr, k);
    }

}
