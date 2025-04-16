import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Graph {
    Map<Integer, List<Integer>> adjList;
    Stack<Integer> stack = new Stack<>();

    public Graph(int v) {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());

        adjList.get(u).add(v);
    }

    public List<Integer> getConnectedNodes(int u) {
        return adjList.getOrDefault(u, new ArrayList<>());
    }

    public void dfs(int source, Set<Integer> visited) {
        stack.push(source);
        visited.add(source);

        List<Integer> connectedNodes = this.getConnectedNodes(source);

        for (Integer node : connectedNodes) {
            if (!visited.contains(node)) {
                dfs(node, visited);
            }
        }
    }

    public void topologicalOrder() {
        this.dfs(1, new HashSet<>());
        for(Integer num : stack){
            System.out.println(num);
        }
        System.out.println("Peek :" + stack.peek());
    }
}
