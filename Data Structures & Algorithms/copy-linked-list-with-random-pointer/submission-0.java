/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            Node newHead = new Node(head.val);
            if(head.random == head) {
                newHead.random = newHead;
                return newHead;
            }
            return newHead;
        }

        Node tmp = head;
        Map<Node, Node> map = new HashMap<>();
        while(tmp != null) {
            Node node = new Node(tmp.val);
            map.put(tmp, node);
            tmp = tmp.next;
        }

        tmp = head;
        while(tmp != null) {
            Node originalNode = tmp;
            Node copyNode = map.get(tmp);
            Node originalNext = tmp.next;
            Node originalRandom = tmp.random;
            copyNode.next = map.get(originalNext);
            copyNode.random = map.get(originalRandom);
            tmp = tmp.next;
        }

        return map.get(head);
    }
}
