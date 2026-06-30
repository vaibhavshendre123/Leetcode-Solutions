class Solution {
    public void bfs(int i,boolean vis[],List<List<Integer>> rooms ){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        while(q.size()>0){

            int front = q.remove();
            for(int j=0; j<rooms.get(front).size(); j++){
                int nextroom = rooms.get(front).get(j);
                if(vis[nextroom]==false){
                    vis[nextroom] = true;
                    q.add(nextroom);
                }
                }
            }
        }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];

        bfs(0,vis,rooms);
        
        for(int i=0; i<vis.length; i++){
            if(vis[i]==false) return false;
        }
        return true;
    }
}