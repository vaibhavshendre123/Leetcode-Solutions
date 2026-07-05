class Solution {
    public void bfs(int sr, int sc, int color,int[][] image,int initcolor){
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc]= color;
        q.add(new int[]{sr,sc});
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(q.size()>0){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0; i<4; i++){
                int row = r+dr[i];
                int col = c+dc[i];
                if(row>=0 && row<image.length && col>=0 && 
                col<image[0].length && image[row][col]==initcolor){
                    image[row][col] = color;
                    q.add(new int[]{row,col});
                }
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int n = image.length;
        int initcolor = image[sr][sc];
        bfs(sr,sc,color,image,initcolor);
        return image;
    }
}