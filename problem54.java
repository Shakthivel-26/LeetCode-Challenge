import java.util.*;

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = cells.length;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == row - 1) return true;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
