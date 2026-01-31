// 23. Merge k Sorted Lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []
 
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Merge2SortedList mergeList = new Merge2SortedList();

        if (lists.length == 0 || (lists.length == 1 && lists[0] == null))
            return null;
        for (int i = 0; i < lists.length - 1; i++) {
            lists[0] = mergeList.mergeTwoLists(lists[0], lists[i + 1]);
        }
        return lists[0];
    }
}
