class Solution {
    public void bfs(int row,int col,char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        grid[row][col] = '0';
        q.add(new int[]{row,col});

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(q.size()>0){
         int[] curr = q.poll();
         int r = curr[0];
         int c = curr[1];
         for(int i=0; i<4; i++){
            int newrow = r+dr[i];
            int newcol = c+dc[i];
            if(newrow >= 0 && newrow<grid.length && newcol >= 0 && 
               newcol<grid[0].length && grid[newrow][newcol]=='1'){
                q.add(new int[]{newrow,newcol});
                grid[newrow][newcol]='0';
            }
         } 
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(i,j,grid);
                    
                }
            }
        }
        return count;
    }
}