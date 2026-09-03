class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }

        int delrow[] = {1,-1,0,0};
        int delcol[] = {0,0,1,-1};

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr[] = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int k=0; k<4;k++){
                    int nrow = row+delrow[k];
                    int ncol = col+delcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==-1){
                        mat[nrow][ncol] = mat[row][col]+1;
                        q.offer(new int[]{nrow,ncol});
                    }
                }
            }
        }
        return mat;
    }
}