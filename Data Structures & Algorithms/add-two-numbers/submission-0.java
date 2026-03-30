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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode ptrL1 = l1;
        ListNode ptrL2 = l2;
        ListNode newHead = null;
        ListNode newPtr = null;

        while(ptrL1 != null && ptrL2 != null) {
            int res = ptrL1.val + ptrL2.val + carry;
            carry = res / 10;
            int rem = res%10;
            if(newHead == null) {
                newHead = new ListNode(rem);
                newPtr = newHead;
            } else {
                ListNode thisNode = new ListNode(rem);
                newPtr.next = thisNode;
                newPtr = newPtr.next;
            }
            ptrL1 = ptrL1.next;
            ptrL2 = ptrL2.next;
        }
        while(ptrL1 != null) {
            int res = ptrL1.val + carry;
            carry = res / 10;
            int rem = res%10;
            
                ListNode thisNode = new ListNode(rem);
                newPtr.next = thisNode;
                newPtr = newPtr.next;
            
            ptrL1 = ptrL1.next;
        }

        while(ptrL2 != null) {
            int res = ptrL2.val + carry;
            carry = res / 10;
            int rem = res%10;
            
                ListNode thisNode = new ListNode(rem);
                newPtr.next = thisNode;
                newPtr = newPtr.next;
            
            ptrL2 = ptrL2.next;
        }
        if(carry != 0) {
            ListNode thisNode = new ListNode(carry);
            newPtr.next = thisNode;
            newPtr = newPtr.next;
        }
        return newHead;
        
    }
}
