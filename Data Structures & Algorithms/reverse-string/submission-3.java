class Solution {
    public void reverseString(char[] s) {
        int j = s.length-1,i=1;
        for (i=0,j=j;i<j;i++,j--){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }

    }
}