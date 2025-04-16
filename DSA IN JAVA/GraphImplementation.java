import java.util.HashSet;

public class GraphImplementation {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println(graph.adjList);
        graph.dfs(1, new HashSet<>());
        
        // System.out.println(graph.getConnectedNodes(0));
    }
}
