//148. Sort List
//Given the head of a linked list, return the list after sorting it in ascending order.

//Example 1:
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]

//Example 2:
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]

//Example 3:
//Input: head = []
//Output: []

import java.util.ArrayList;

public class SortLL {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(null);
        head = new ListNode(0);
        ListNode cur = head;
        for (Integer val: list) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
    }
}
