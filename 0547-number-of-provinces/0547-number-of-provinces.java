class Solution {
    public void bfs(int i,boolean [] vis,int[][] arr){
        int n = arr.length;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(q.size()>0){
            int front = q.remove();
            for(int j=0; j<n; j++){
                if(arr[front][j]==1 && vis[j]==false){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(vis[i]==false){
                count++;
                bfs(i,vis,isConnected);
            }
        }
        return count;
    }
}