class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        HashSet<Integer> set = new HashSet<>();
        
        while(n!=1){
            
            if(set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            while(n!=0){
                int x = n%10;
                n = n/10;
                sum += x*x;
            }
            n = sum;
            if(n==1) return true;
            
        }
        return false;
    }
}