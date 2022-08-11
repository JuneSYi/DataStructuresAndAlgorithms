package Amazon;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int count = 0;
        int[] temp = new int[cells.length];
        while (count < n) {

            temp = cells.clone();
            for (int i = 1; i < cells.length-1; i++) {
                if(cells[i-1] == cells[i+1]) {
                    temp[i] = 1;

                } else {
                    temp[i] = 0;
                }
            }
            temp[0] = 0; temp[cells.length-1] = 0;
            cells = temp.clone();
            count++;
        }
        return cells;
    }
}
