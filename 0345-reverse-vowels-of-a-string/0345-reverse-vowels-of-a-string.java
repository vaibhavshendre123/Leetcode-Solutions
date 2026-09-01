class Solution {
    public static boolean isVowel(char ch){
         if(ch == 'a'|| ch== 'e' || ch == 'i'|| ch == 'o'|| ch == 'u' || 
           ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U'){
            return true;
           }
           return false;
    }
    public String reverseVowels(String s) {
       char [] arr = s.toCharArray();
       int l = 0;
       int r = s.length()-1;

       while(l<r){
        while(l<r && !isVowel(arr[l])) l++;
        while(l<r && !isVowel(arr[r])) r--;

         char temp = arr[l];
         arr[l] = arr[r];
         arr[r] = temp;
         l++;
         r--;
       }
       return new String(arr);
    }
}