class Solution {
    public String reverseWords(String s) {
        String[] word = s.trim().split("\\s+");
        int n = word.length;

        StringBuilder ans = new StringBuilder();

        for(int i=n-1; i>=0; i--){
            ans.append(word[i]);
            if(i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}