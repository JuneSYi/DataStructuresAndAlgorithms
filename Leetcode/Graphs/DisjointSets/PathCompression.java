package Graphs.DisjointSets;

public class PathCompression {
    private int[] root;

    public PathCompression(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) { // checking whether parent node of x is equal it itself
            return x;
        }
        return root[x] = find(root[x]); // use recursion to keep searching if not equal
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        PathCompression uf = new PathCompression(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2); // root[2] = 1
        uf.union(2, 5); // find(root[2]) = 1, thus root x = 1, root[5] = 1
        uf.union(5, 6); // find(5), rootx=1, rooty=6, root[6] = 1
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }

}
