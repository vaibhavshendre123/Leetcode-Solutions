class Solution {
    public void bfs(int source, boolean visited[], List<List<Integer>> adj ){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(q.size()>0){
            int front = q.remove();
            for(int i=0; i<adj.get(front).size(); i++){
                int next = adj.get(front).get(i);
                if(visited[next]==false){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
          List<Integer> list = new ArrayList<>();
          adj.add(list);
        }
        for(int j=0; j<edges.length; j++){
            int a = edges[j][0]; int b = edges[j][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean visited[] =  new boolean[n];

        bfs(source,visited,adj);
        if(visited[destination]==false) return false;
        return true;
    }
}