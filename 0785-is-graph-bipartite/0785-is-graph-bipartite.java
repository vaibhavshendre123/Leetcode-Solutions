class Solution {
    static boolean ans;
    public static void bfs(int i,int[][] graph, int[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = 0;
        while(q.size()>0){
          int front = q.remove();
          
          int color = visited[front];
          for(int ele : graph[front]){
              if(visited[ele]==color){
                ans = false;
                return;
              }
              if(visited[ele]==-1){
                visited[ele] = 1-color;
                q.add(ele);
              }
          }
        }
    }
    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited,-1);

        for(int i=0; i<n; i++){
            if(ans==false) return ans;
            if(visited[i]==-1){
                bfs(i,graph,visited);
            }
        }
        return ans;
    }
}