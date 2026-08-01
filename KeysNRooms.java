// 841. Keys and Rooms
// There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
// When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
// Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

// Example 1:
// Input: rooms = [[1],[2],[3],[]]
// Output: true
// Explanation: 
// We visit room 0 and pick up key 1.
// We then visit room 1 and pick up key 2.
// We then visit room 2 and pick up key 3.
// We then visit room 3.
// Since we were able to visit every room, we return true.

// Example 2:
// Input: rooms = [[1,3],[3,0,1],[2],[0]]
// Output: false
// Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 


import java.util.HashSet;
import java.util.List;

public class KeysNRooms {
    private void dfs(int i, List<List<Integer>> rooms, boolean[] isVisited) {
        if (isVisited[i]) return;
        
        isVisited[i] = true;
        
        for(Integer room: rooms.get(i)) 
            if (!isVisited[room]) dfs(room, rooms, isVisited);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];

        dfs(0, rooms, isVisited);

        for (boolean v: isVisited) 
            if (!v) return false;
        return true;
    }

    private void dfsLazy(int i, List<List<Integer>> rooms, HashSet<Integer> keys, boolean[] isVisited) {
        if (i == 0 || keys.contains(i)) isVisited[i] = true;
        
        keys.addAll(rooms.get(i));
        for(Integer room: rooms.get(i)) 
            if (!isVisited[room]) dfsLazy(room, rooms, keys, isVisited);
    }

    public boolean canVisitAllRoomsLazy(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        HashSet<Integer> keys = new HashSet<>();

        dfsLazy(0, rooms, keys, isVisited);

        for (boolean v: isVisited) 
            if (!v) return false;
        return true;
    }
}
