import java.util.*;
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, ArrayList<Integer>> rows = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> cols = new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rows.computeIfAbsent(x, v -> new ArrayList<>()).add(y);
            cols.computeIfAbsent(y, v -> new ArrayList<>()).add(x);
        }
        for (ArrayList<Integer> list : rows.values()) Collections.sort(list);
        for (ArrayList<Integer> list : cols.values()) Collections.sort(list);
        int covered = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            ArrayList<Integer> r = rows.get(x);
            ArrayList<Integer> c = cols.get(y);
            int posRow = Collections.binarySearch(r, y);
            int posCol = Collections.binarySearch(c, x);
            boolean left  = posRow > 0;
            boolean right = posRow < r.size() - 1;
            boolean up    = posCol > 0;
            boolean down  = posCol < c.size() - 1;
            if (left && right && up && down)
                covered++;
        }
        return covered;
    }
}
