// 547. Number of Provinces
// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
// Return the total number of provinces.

// Example 1:
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2

// Example 2:
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3
 

public class NoOfProvinces {
    private void dfs(int city, boolean[] visited, int[][] isConnected) {
        visited[city] = true;
        for (int next = 0; next < isConnected.length; next++) 
            if(isConnected[city][next] == 1 && !visited[next]) dfs(next, visited, isConnected);
    }

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int city = 0; city < n; city++) 
            if (!visited[city]) {
                dfs(city, visited, isConnected);
                provinces++;
            }

        return provinces;
    }
}
