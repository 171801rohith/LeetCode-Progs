// 802. Find Eventual Safe States
// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

// Example 1:
// Illustration of graph
// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation: The given graph is shown above.
// Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

// Example 2:
// Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
// Output: [4]
// Explanation:
// Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindEventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        int[] outdeg = new int[n];
        boolean[] safe = new boolean[n];
        Deque<Integer> terminal = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> reverse = new ArrayList<>();

        for (int i = 0; i < n; i++) reverse.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            outdeg[i] = graph[i].length;
            if (outdeg[i] == 0) terminal.offer(i);

            for (int j = 0; j < outdeg[i]; j++) reverse.get(graph[i][j]).add(i);
        }

        while (!terminal.isEmpty()) {
            int node = terminal.poll();
            safe[node] = true;

            for (int prev: reverse.get(node)) {
                outdeg[prev]--;
                if (outdeg[prev] == 0) terminal.offer(prev);
            }
        }

        for (int i = 0; i < n; i++) if (safe[i]) list.add(i);

        return list;
    }
}
