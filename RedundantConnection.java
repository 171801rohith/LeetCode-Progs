// 684. Redundant Connection
// In this problem, a tree is an undirected graph that is connected and has no cycles.
// You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
// Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

// Example 1:
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]

// Example 2:
// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: [1,4]
 

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
        int[] parent;

    private int find(int x) {
        if (parent[x] == x)return x;
        return find(parent[x]);
    }

    private void union(int x, int y) {
        parent[y] = x;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e: edges) {
            int leadA = find(e[0]);
            int leadB = find(e[1]);

            if (leadA != leadB) union(leadA, leadB);
            else return e;
        }
        return new int[0];
    }




    private boolean dfs(int u, int v, List<List<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        if (u == v) return true;
        for (Integer i: graph.get(u)) 
            if (!visited[i] && dfs(i, v, graph, visited)) return true;
        return false;
    }

    public int[] findRedundantConnectionLazy(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(edges.length + 1);

        for (int i = 0; i <= edges.length; i++) graph.add(new ArrayList<>());
        for (int[] edge: edges) {
             int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[edges.length + 1];

            if (!graph.get(u).isEmpty() &&
                !graph.get(v).isEmpty() &&
                dfs(u, v, graph, visited)) {
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }
}
