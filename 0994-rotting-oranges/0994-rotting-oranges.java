class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2){
                q.offer(new int[]{i,j});
                }
            }
        }
        int[] delrow = {1,-1,0,0};
        int[] delcol = {0,0,1,-1};

        int minutes = 0;
        //bfs
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int k=0; k<4; k++){
                    int nr = r+delrow[k];
                    int nc = c+delcol[k];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0?minutes:-1;
    }
}