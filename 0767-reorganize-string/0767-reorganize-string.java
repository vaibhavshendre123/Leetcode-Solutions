class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int [] freq = new int[26];

        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0; i<26; i++){
            if(freq[i]>0) pq.offer(new int[]{i,freq[i]});
        } 

        StringBuilder result = new StringBuilder();
        int [] prev = null;

        while(pq.size()>0){
            int[] curr = pq.poll();
            result.append((char)(curr[0]+'a'));
            curr[1]--;

            if(prev != null && prev[1]>0){
                pq.offer(prev);
            }
            prev = curr;
        }

        if(s.length()==result.length()) return result.toString();
        else return "";
    }
}