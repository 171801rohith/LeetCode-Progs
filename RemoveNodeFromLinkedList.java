// 2487. Remove Nodes From Linked List
// You are given the head of a linked list.
// Remove every node which has a node with a greater value anywhere to the right side of it.
// Return the head of the modified linked list.

// Example 1:
// Input: head = [5,2,13,3,8]
// Output: [13,8]
// Explanation: The nodes that should be removed are 5, 2 and 3.
// - Node 13 is to the right of node 5.
// - Node 13 is to the right of node 2.
// - Node 8 is to the right of node 3.

// Example 2:
// Input: head = [1,1,1,1]
// Output: [1,1,1,1]
// Explanation: Every node has value 1, so no nodes are removed.
 

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class RemoveNodeFromLinkedList {
    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;        
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        int max = head.val;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < max) prev.next = cur.next;
            else {
                max = cur.val;
                prev = cur;
            }
            cur = cur.next;
        }
        return reverseList(dummy.next);
    }

    public ListNode removeNodesLazy(ListNode head) {
        Deque<ListNode> stk = new ArrayDeque<>();

        ListNode cur = head;
        while (cur != null) {
            while (!stk.isEmpty() && stk.peek().val < cur.val) stk.pop();
            stk.push(cur);
            cur = cur.next;
        }

        Iterator<ListNode> it = stk.descendingIterator();
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode node;

        while (it.hasNext()) {
            node = it.next(); 
            prev.next = node;
            prev = node;
        }
        prev.next = null;
        return dummy.next; 
    }
}
