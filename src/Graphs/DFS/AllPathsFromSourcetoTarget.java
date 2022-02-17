package Graphs.DFS;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourcetoTarget {
    /*
    given a directed acyclic graph of n nodes labeled from 0 to n-1, find all possible paths from node 0 to node n-1
    and return them in any order

    graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e. there is a directed edge from node i to node graph[i][j]

    example: graph = [[1,2],[3],[3],[]]
    node 0 can go to 1 and 2, node 1 can go to 3, node 2 can go to 3
    so the answer will be 2 paths, 0-1-3 and 0-2-3

    example 2:
    Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
    Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    5 ways
     */

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) return paths;

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;

    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node); //starts with index 0
        if(node == graph.length-1) { // base case, once node reaches the end node, we add the arraylist to paths
            // paths is our final answer with all the arraylists
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node]; // we places the values of the first node (0) into an array
        for (int nextNode: nextNodes) { //we loop through the array and perform recursion
            dfs(graph, nextNode, path, paths);
            path.remove(path.size()-1); // why remove last index in path?
            /*
            Classic backtracking template.
                Make a choice.
                Explore on that choice by recursing.
                Undo the choice -- this is where you decrement the length by undoing step 1.
             We have found a path which has been copied to the 'res' list already. Now we're going back one node to
                see other solutions, so we remove the last index of the list.
             It's backtracking. We incrementally build candidates to the solution, and abandon a candidate
                ("backtrack") as soon as its determined that the candidate cannot possibly be completed to a valid
                solution.
             */
        }
    }


}
