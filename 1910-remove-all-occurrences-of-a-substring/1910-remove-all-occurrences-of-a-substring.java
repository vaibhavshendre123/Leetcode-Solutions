class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int m = s.length();
        int n = part.length();

        for(int i=0; i<m; i++){
            boolean match = true;

            sb.append(s.charAt(i));

            if(sb.length()>=n){
             for(int j=0; j<n; j++){
             if(sb.charAt(sb.length()-n+j) != part.charAt(j)){
                match = false;
                break;
             }
             }
             if(match==true){
                sb.delete(sb.length()-n,sb.length());
             }
            }
        }
        return sb.toString();
    }
}