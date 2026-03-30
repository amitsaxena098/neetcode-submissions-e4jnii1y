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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode newHead = null;
        ListNode ptr = null;
        ListNode ptrL1 = list1;
        ListNode ptrL2 = list2;

        while(ptrL1 != null && ptrL2 != null) {
            if(newHead == null) {
                newHead = new ListNode();
                ptr = newHead;
            } else {
                ListNode thisNode = new ListNode();
                ptr.next = thisNode;
                ptr = ptr.next;
            }
            if(ptrL1.val < ptrL2.val) {
                ptr.val = ptrL1.val;
                ptrL1 = ptrL1.next;
            } else {
                ptr.val = ptrL2.val;
                ptrL2 = ptrL2.next;
            }
        }
        if(ptrL1 != null) {
            ptr.next = ptrL1;
        }
        if(ptrL2 != null) {
            ptr.next = ptrL2;
        }

        return newHead;
        
    }
}