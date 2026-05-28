class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "");
        clean=clean.toLowerCase();
        char[] str=clean.toCharArray();
        boolean value= true;
        for(int i=0,j=str.length-1;i<j;i++,j--){
            if(str[i]!=str[j]){
                value=false;
                break;
            }
        }
        return value;
    }
}