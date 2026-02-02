// 61. Rotate List
// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k %= len;
        if (k == 0)
            return head;

        ListNode cur = head;
        for (int i = 0; i < len - k - 1; i++)
            cur = cur.next;

        ListNode new_head = cur.next;
        cur.next = null;
        tail.next = head;

        return new_head;

    }
}
