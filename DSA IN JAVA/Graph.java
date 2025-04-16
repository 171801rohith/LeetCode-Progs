import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    Map<Integer, List<Integer>> adjList;

    public Graph(int v) {
        adjList = new HashMap<>();
        // for (int i = 0; i < v; i++) {
        // adjList.put(i, new ArrayList<>());
        // }
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        // Undirected Graph
        adjList.get(u).add(v);
        adjList.get(v).add(u);

        // // Directed Graph
        // adjList.get(u).add(v);
    }

    public List<Integer> getConnectedNodes(int u) {
        return adjList.getOrDefault(u, new ArrayList<>());
    }

    public void dfs(int source, Set<Integer> visited) {
        System.out.println(source);
        visited.add(source);
        List<Integer> connectedNodes = this.getConnectedNodes(source);
        for (int node: connectedNodes){
            if(!visited.contains(node)){
                dfs(node, visited);
            }
        }
    }
}
