// 207. Course Schedule
// Hint
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false. 

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 


import java.util.ArrayList;
import java.util.List;

public class CourseScheduler {
    private boolean dfs(int i, List<List<Integer>> graph, int[] state) {
        if (state[i] == 1) return false;
        if (state[i] == 2) return true;

        state[i] = 1;
        for (Integer neigh: graph.get(i)) 
            if (!dfs(neigh, graph, state)) return false;
        
        state[i] = 2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) graph.get(prerequisites[i][1]).add(prerequisites[i][0]);

        for (int i = 0; i < numCourses; i++) 
            if  (state[i] == 0) 
                if (!dfs(i, graph, state)) return false;
        
        return true;
    }
}
