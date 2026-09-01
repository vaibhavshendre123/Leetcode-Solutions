class Solution {
    public String reverseVowels(String s) {
        char [] arr = s.toCharArray();
        String x="";
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
        char ch= s.charAt(i);
        if(ch == 'a'|| ch== 'e' || ch == 'i'|| ch == 'o'|| ch == 'u' || 
           ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U'){
            st.push(ch);
           }
        }
        for(int i=0; i<n; i++){
        char ch= s.charAt(i);
        if(ch == 'a'|| ch== 'e' || ch == 'i'|| ch == 'o'|| ch == 'u' || 
           ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U'){
            arr[i] = st.pop();
           }
        }
        s = new String(arr);
        return s ;
    }
}