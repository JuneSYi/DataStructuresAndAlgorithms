package Graphs;

public class temp {
    private int j;

    public temp(int j) {
        this.j = j;
    }

    public int getJ() {
        return j;
    }

    public static void main(String[] args) {
        temp uf = new temp(4);
        System.out.println(uf.getJ());
    }

}
