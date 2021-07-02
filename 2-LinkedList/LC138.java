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
    public void copyNodes(Node head) {
        Node curr = head;
        while(curr != null) {
            Node forw = curr.next;
            Node rNode = new Node(curr.val);
            curr.next = rNode;
            rNode.next = forw;
            curr = forw;
        }
    }
    public void copyRandom(Node head) {
        Node curr = head;
        while(curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
    }
    public Node extractList(Node head) {
        Node dummy = new Node(-1);
        Node curr = head, prev = dummy;
        while(curr != null) {
            prev.next = curr.next;
            prev = prev.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        copyNodes(head);
        copyRandom(head);
        return extractList(head);
    }
}