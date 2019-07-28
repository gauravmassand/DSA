package linkedlist;

/*
876. Middle of the Linked List(https://leetcode.com/problems/middle-of-the-linked-list/)
Maintain two pointer slow and fast.Slow at head fast at head.next;
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5])
*/

public class MiddleElement {
    public ListNode middleNode(ListNode head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return head;
        }
        ListNode slowNode =head;
        ListNode fastNode=head.next;
        while(fastNode!=null ) {
            if(fastNode.next==null) {
                fastNode=null;
            }
            else {
                fastNode=fastNode.next.next;
            }
            slowNode=slowNode.next;
        }
        return slowNode;
    }
}
