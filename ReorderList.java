// 143. Reorder List
// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 


public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalf = head;
        ListNode secHalf = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode cur = secHalf;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        secHalf = prev;

        ListNode first = firstHalf;
        ListNode sec = secHalf;
        ListNode fNext, sNext;

        while (sec != null) {
            fNext = first.next;
            sNext = sec.next;
            
            first.next = sec;
            sec.next = fNext;

            first = fNext;
            sec = sNext;
        }
    }
}
