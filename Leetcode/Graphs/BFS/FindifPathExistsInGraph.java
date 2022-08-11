package Graphs.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindifPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n]; // to keep track of paths visited
        HashSet<Integer>[] graph = new HashSet[n]; // we'll use this to map out the edges

        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<>(); // adding a new hashset in each index
        }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        if(graph[start].contains(end)){  // direct connection exists
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // initial starting point
        visited[start] = true; // marked as visited

        while(!queue.isEmpty()){ // remains true while there is something in the queue
            int current = queue.poll(); // takes the first element of the list, removes from original queue
            if(current == end){ // if value that's taken off queue is equal to end, you've reached the destination
                return true;
            }

            for(Integer neighbor : graph[current]){ // for every integer within the hashset of the latest queue value
                if(!visited[neighbor]){ // if the node has not been visited yet then true
                    visited[neighbor] = true; // we mark the node as true
                    queue.add(neighbor); //we add that node to the queue
                }
            }
        }
        return false;
    }
}
