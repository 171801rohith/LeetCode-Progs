// 234. Palindrome Linked List
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

import java.util.ArrayList;

public class PallindromeLinkedList {
       public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (cur.next != null) {
            cur.next = next.next;
            next.next = head;
            head = next;
            next = cur.next;
        }
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ArrayList<Integer> l1 = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            l1.add(temp.val);
            temp = temp.next;
        }
        ArrayList<Integer> l2 = new ArrayList<>();
        ListNode revList = reverseList(head);
        temp = revList;
        while (temp != null) {
            l2.add(temp.val);
            temp = temp.next;
        }

        for(int i = 0; i < l2.size(); i++){
            if (l1.get(i) != l2.get(i))
                return false;
        }
        return true;
    }
}
