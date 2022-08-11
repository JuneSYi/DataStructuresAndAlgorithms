package Graphs.DisjointSets;

/**
 * making our decision by the height of the tree, we choose the tallest tree to
 * make the root
 */
public class UnionByRank {
    
    private int[] root;
    private int[] rank; //used to record the height of the vertex

    public UnionByRank(int size) {
        root = new int[size];
        rank = new int[size]; // 2 arrays based on size
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // each start with rank 1
        }
    }
    // same as quickunion
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y); // first find root nodes of x and y
        if (rootX != rootY) { // then check if they're the same
            if (rank[rootX] > rank[rootY]) { // compares the height of the 2 nodes
                root[rootY] = rootX; // if root node of X is >, we'll update rootY
            } else if (rank[rootX] < rank[rootY]) { // vice verse
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX; // if heights are equal, then we can choose either. here we choose rootX
                rank[rootX] += 1; // increases the tree by 1. important.
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        UnionByRank uf = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2); // rtx = 1, rty = 2, root[2]=1, rank[1] = 2
        uf.union(2, 5); // rtx = 1, rty = 5, since rank[1]>rank[5], root[5] = 1
        uf.union(5, 6); // rtx = 1, rty = 6, rank[1]>rank[6], root[6] = 1
        uf.union(6, 7); // rtx = 1, rty = 7, r1>r7, r7=1
        uf.union(3, 8); // rtx = 3, rty = 8, root[8] = 3, rank[3] = 2
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

