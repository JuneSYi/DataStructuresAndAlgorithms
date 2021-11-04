package Graphs.DisjointSets;

public class QuickFind {
    // UnionFind.class
        private int[] root; // root array

        public QuickFind(int size) { // constructor, size = elements in array
            root = new int[size]; // size = # of vertices,
            for (int i = 0; i < size; i++) { //initialize root to have the number of size of vertices
                root[i] = i; //root will initially be filled with zeroes
            }
        }
        //find(int x) = time complexity equal O(1)
        public int find(int x) { //find function, since every element will be pointing
            // to its root node, we can just return root[x]
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {             // time complexity = O(N), going through array

                //if the root nodes are not equal, we'll have to go through the entire root array
                // once we see a value equal to the root ofy
                for (int i = 0; i < root.length; i++) { //when the corresponding root node is equal to the node we are
                    // merging (rootY) then we'll have to change the root node to the new rooot. rootX in this case
                    if (root[i] == rootY) {
                        root[i] = rootX;
                    }
                }
            }
        }
        public boolean connected(int x, int y) { //function determines if X and Y are connected
            return find(x) == find(y);
        }
    public static void main(String[] args) throws Exception {
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
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

    // App.java
    // Test Case
//    public class App {


//}
