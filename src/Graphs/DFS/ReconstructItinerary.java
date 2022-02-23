package Graphs.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a LC hard problem, skipping but leaving the pile of crap that i left here. it's not correct
 *
 * i repeat, this is unfinished and not correct
 */

public class ReconstructItinerary {
    /*
    You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure
    and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

    All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical
    order when read as a single string.

    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        /*
        we have a list of a list
        we want to find first the List<String>[0] == "JFK"
        we place that string into List<String> path
        we want to mark that string as visited
        if visited, return to for each loop

        think about: it's a directed path, all connected, if match doesn't exist we can backtrack...no?
         */
        if (tickets.size() == 1) return tickets.get(0);
        boolean[] visited = new boolean[tickets.size()];
        List<String> path = new ArrayList<String>();
        dfs(visited, tickets, path, 0);
        return path;
    }

    private void dfs(boolean[] visited, List<List<String>> tickets, List<String> path, int node) {
        // base case
        if (visited[node] || path.size() == tickets.size()) return;
        // recursive step
        for (List<String> edge : tickets) {
            if (edge.get(0).equals("JFK")) {
                path.add(edge.get(0));
                path.add(edge.get(1));
                visited[node] = true;
                tickets.remove(node);
            }
        }
    }
}
