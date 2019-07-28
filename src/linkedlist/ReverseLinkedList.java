package linkedlist;

/*
206. Reverse Linked List(https://leetcode.com/problems/reverse-linked-list/)
current = head;
previous = null

Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous =null;
        while(current !=null) {
            ListNode ahead = current.next;
            current.next = previous;
            previous = current;
            current = ahead;
        }
        head = previous;
        return head;


    }
}
