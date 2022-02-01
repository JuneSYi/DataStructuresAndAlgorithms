package Graphs.DFS;

import java.util.*;

/**
 * leetcode 1971
 * given: n = nodes, edges = each path, start and end node
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 */
public class findIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>(); // we set up a list of lists
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>()); // we add a list for each node that's given (e.g. 3)
        }

        for (int[] edge : edges) { //for every int array provided in edges
            adjacency_list.get(edge[0]).add(edge[1]); //for each int array, there's a 0 and 1 index
            adjacency_list.get(edge[1]).add(edge[0]); // bi-directional?
            /* best explanation so far: makeSameGroup(e[0] , e[1]); makes sure that e[0] and e[1] belong to the same
            group and hence have the same parent. Hence makeSameGroup(e[1] , e[0]); becomes a redundant task.

            another similar explaination: The question says that each edge denotes a bidirectional edge.
            To represent those two edges we are pushing the nodes in the graph.
             */
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);

        while (!stack.isEmpty()) {
            // Get the current node.
            int node = stack.pop();

            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }

            // Check if we've already visited this node.
            if (seen[node]) {
                continue;
            }
            seen[node] = true;

            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }

        return false;
    }

    private boolean seen;
    public boolean usingHashSet(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;

        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        if(graph[start].contains(end)){  // direct connection exists
            return true;
        }

        seen = false;
        dfs(graph, visited, start, end);
        return seen;
    }

    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int start, int end){
        if(!visited[start] && !seen){
            if(start == end){
                seen = true;
                return;
            }

            visited[start] = true;
            for(Integer neighbor : graph[start]){
                dfs(graph, visited, neighbor, end);
            }
        }
    }
}
