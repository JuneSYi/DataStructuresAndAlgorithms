package Graphs.DisjointSets;

public class QuickUnion {
    private int[] root;

    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        while (x != root[x]) { // while loop is checking whether the root vertex is equal to the current element
            x = root[x]; // if not equal, we'll continue searching through its parent
        } //this allows us to use the find method to find the root of x O(N) complexity in worst case
        return x;
    }

    public void union(int x, int y) { // checking whether the root nodes are equal, if not, we set the rooty to rootx
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX; // also O(N)
        }
    }

    public boolean connected(int x, int y) { //O(N) time complexity
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        QuickUnion uf = new QuickUnion(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2); // root[2] = 1
        uf.union(2, 5); // find(x) will return 1, root[5] = 1
        uf.union(5, 6); // find(x) will return 1, root[6] = 1
        uf.union(6, 7); // all will point to 1
        uf.union(3, 8); // 8 points to 3
        uf.union(8, 9); // 9 points to 3
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
