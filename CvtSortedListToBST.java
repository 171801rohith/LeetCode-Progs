// 109. Convert Sorted List to Binary Search Tree
// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// Example 1:
// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

// Example 2:
// Input: head = []
// Output: []
 

import java.util.ArrayList;
import java.util.List;

public class CvtSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        if(head.next == null)
            return new TreeNode(head.val);


        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    private TreeNode buildTree(List<Integer> list, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = buildTree(list, low, mid - 1);
        root.right = buildTree(list, mid + 1, high);

        return root;
    }

    
    public TreeNode sortedListToBSTLazy(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add((head.val));
            head = head.next;
        }

        return buildTree(list, 0, list.size() - 1);
    }
}
