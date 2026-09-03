class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        // Put all rotten oranges into queue
        // and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // Process all oranges that are rotten
            // at the current minute
            for (int i = 0; i < size; i++) {

                int[] current = q.poll();

                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}