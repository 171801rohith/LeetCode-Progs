// 82. Remove Duplicates from Sorted List II
// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]

// Example 2:
// Input: head = [1,1,1,2,3]
// Output: [2,3]

import java.util.Map;
import java.util.LinkedHashMap;

public class DeleteDuplicateList2 {
    public void insertNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode insert = new ListNode(val);
        while (cur.next != null)
            cur = cur.next;
        cur.next = insert;
    }

    public ListNode deleteDuplicates(ListNode head) {
        // HashMap<Integer, Integer> count = new HashMap<>();

        // to preserve the insertion order LinkedHashMap
        Map<Integer, Integer> count = new LinkedHashMap<>();

        while (head != null) {
            if (!count.containsKey(head.val))
                count.put(head.val, 1);
            else
                count.computeIfPresent(head.val, (key, val) -> val + 1);
            head = head.next;
        }
        System.out.println(count);

        ListNode result = new ListNode();
        // for (Integer key : count.keySet()) {
        //     if (count.get(key) == 1) {
        //         insertNode(result, key);
        //     }
        // }
        
        // to prevent repeated get() calls
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() == 1) insertNode(result, entry.getKey());
        }
        return result.next;
    }
}

