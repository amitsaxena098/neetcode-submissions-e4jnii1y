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

        int count = 0;
        ListNode tmp = head;
        while(tmp != null) {
            count++;
            tmp = tmp.next;
        }
        System.out.println("count : " + count);

        int index = count - n-1;
        tmp = head;
        while(index != 0 && tmp != null) {
            tmp = tmp.next;
            index--;
        }
        if(count - n == 0) return head.next;
        tmp.next = tmp.next.next;
        return head;

    }
}

// 1->2>3>4>5
// 5 - 2 = 3

