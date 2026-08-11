// 92. Reverse Linked List II
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]
 

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;

        for (int i = 1; i < left; i++) before = before.next;

        ListNode prev = null;
        ListNode start = before.next;
        ListNode cur = start;
        ListNode next;

        for (int i = left; i <= right; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        before.next = prev;
        start.next = cur;

        return dummy.next;
        
    }
}
