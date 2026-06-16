class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(int ch:tasks){
            freq[ch-'A']++;
        }
        int maxfreq = 0;
        for(int f:freq){
            maxfreq = Math.max(maxfreq,f);
        }
        int countmax = 0;
        for(int i:freq){
            if(i==maxfreq) countmax++;
        }

        int formula = (maxfreq-1)*(n+1)+countmax;
        return Math.max(formula,tasks.length);
    }
}