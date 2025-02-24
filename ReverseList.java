// 206. Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

// Example 2:
// Input: head = [1,2]
// Output: [2,1]

// Example 3:
// Input: head = []
// Output: []

public class ReverseList {
        public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while(cur.next != null){
        System.out.println(next.val);
            cur.next = next.next;
            next.next = head;
            head = next;
            next = cur.next;
        }
        return head;
    }
}
