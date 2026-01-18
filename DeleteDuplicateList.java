// 83. Remove Duplicates from Sorted List
// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]

// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]
 

import java.util.ArrayList;

public class DeleteDuplicateList {
    public void insertEnd(ListNode head, int val) {
        ListNode cur = head;
        ListNode insert = new ListNode(val);
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = insert;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            if (!list.contains(head.val))
                list.add(head.val);
            head = head.next;
        }
        System.out.println(list);

        ListNode result = new ListNode();
        for (Integer i : list) {
            insertEnd(result, i);
        }
        return result.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;

        }
        return head;
    }
}
