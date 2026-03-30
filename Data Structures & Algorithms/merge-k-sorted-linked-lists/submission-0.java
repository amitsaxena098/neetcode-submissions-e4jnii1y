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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 ) return null;
        if(lists.length == 1) return lists[0];
        ListNode root = null;
        for(int i = 0 ; i < lists.length; i++) {
            root = mergeTwoList(root, lists[i]);
        }
        return root;

    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        ListNode newRoot = null;
        if(ptr1.val <= ptr2.val) {
            newRoot = ptr1;
            ptr1 = ptr1.next;
            newRoot.next = null;
        } else {
            newRoot = ptr2;
            ptr2 = ptr2.next;
            newRoot.next = null;
        }
        ListNode ptr = newRoot;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val >= ptr2.val) {
                ptr.next = ptr2;
                ptr = ptr.next;
                ptr2 = ptr2.next;
                ptr.next = null;
            } else {
                ptr.next = ptr1;
                ptr = ptr.next;
                ptr1 = ptr1.next;
                ptr.next = null;
            }
        }
        if(ptr1 != null) {
            ptr.next = ptr1;
        }
        if(ptr2 != null) {
            ptr.next = ptr2;
        }
        return newRoot;
        
    }
}
