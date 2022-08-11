package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
We are given a directed graph.

Also, as inputs we are provided a source and a destination.

We need to tell if all the paths from the source lead to the destination and and we can split this into a few criteria.
    If a path exists from the source node to a node with no outgoing edges, then that node must be equal to destination.
    Here, we simply need to see that if a node does not have any neighbors in the adjacency list structure, then it has to
    be the destination or else we return false.

    The number of possible paths from source to destination is a finite number. This simply means that the graph is
    actually a tree. Or in other words, there are no cycles in the graph. If there is a cycle in the graph, there would be
    an infinite number of paths from the source to the destination, as each would go around the cycle a different number
    of times.
 */
public class AllPathsFromSourceLeadtoDestination {
    boolean found = false;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        boolean found = false;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i =0; i< n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        //dfs
        dfs(graph, visited, source, destination);
        return found;
    }
    /* hashmap
    0 : 1, 3
    1 : 2
    2 : 1
     */
    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int source, int destination) {
        // base
        if (visited[source] == true) {
            return;
        }
        visited[source] = true;

        if(source == destination) {
            found = true;
            return;
        }

        // recursive
        for (int node : graph.get(source)) {
            dfs(graph, visited, node, destination);
        }
    }
}
