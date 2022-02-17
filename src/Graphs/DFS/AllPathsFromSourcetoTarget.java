package Graphs.DFS;

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
        /*
        can we put it on a map?
        [[1,2],
        [3],
        [3],
        []]
        dfs can check if node = n-1. then return with adding that list<Integer>
        each key/node points to the values where they're all located, if it ends in n-1
        we add the
         */
        int length = graph.length;
        Map<Integer, List<Integer>> dot = new HashMap<>();
        for (int i =0 ; i<length;i++) {
            dot.put(i,new ArrayList<>());
        }

        for(int[] edge: graph) {

        }
    }
}
