package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DNF
 */
public class NumberOfIslands {
    int ans;
    public int numIslands(char[][] grid) {
        ans =0;
        /*
        if grid[1][1] is an island, we need to check if grid[0][1], grid[2][1], grid[1][0], grid[1][2] is equal to 0
         */
        dfs(grid,0,0);
        return ans;
    }
    void dfs(char[][] grid, int x, int y) {
        // base case

    }
}
