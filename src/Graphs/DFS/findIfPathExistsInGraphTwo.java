package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
each vertex is labeled from 0 to n-1
edges are represented as a 2d int array
determine if there is a valid path that exists from start to end
n = vertices/nodes
 */
//https://leetcode.com/problems/find-if-path-exists-in-graph/discuss/1408896/Java-Simple-DFS
public class findIfPathExistsInGraphTwo {
    boolean found;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        found = false;

        if (start == end) return true; // if start == end, then it's connected

        Map<Integer, List<Integer>> graph = new HashMap<>(); //we want to construct the edges in a map...but why?
        boolean[] visited = new boolean[n]; // a boolean array the length of how many nodes exists

        for (int i = 0; i < n; i++) { // for number of nodes
            graph.put(i, new ArrayList()); // we make each key a new arraylist. graph
        }

        //construct graph, add bidirectional vertex
        for (int[] edge : edges) { // with the edges provided from input, we map out the hashmap by allocating each key
            // using data from the 2d int array. each int array has edge[0] and edge[1]
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            /*
            we grab the key represented by the value from the edge[]
            for each key we add the value of the other edge in order to create a bi directional vertex.
            so each key will have the other edge value showing connecting throughout the hashmap
            e.g. node(key) 1 will show connect to value 2
            e.g. node(key) 2 will show connect to value 1.
            so on and so forth until the entire 2d array is allocated to hashmap.
            in finality, the entire hashmap will show what value each vertice is connected to.
             */
        }

        //start dfs from start point
        dfs(graph,visited, start, end);

        return found;

    }

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start, int end) {
        if(visited[start] || found) return;

        visited[start]=true;
        //when we found and neighbor which is equal to end point inside the recursion, done. break and return true
        for(int nei: graph.get(start)) { // goes through entire List<Integer>, if end not found, nei is last node
            if (nei == end) {
                found = true;
                break;
            }
            if(!visited[nei]) // if false, then true. continue recursion
                dfs(graph,visited,nei,end); // same graph, same visited, start is now va
        }
    }
}
