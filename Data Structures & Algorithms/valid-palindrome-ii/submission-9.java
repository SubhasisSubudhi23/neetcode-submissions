class Solution {
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        
        // Your exact for loop!
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            
            // We found a mismatch!
            if (str[i] != str[j]) {
                
                // Path 1: Pretend we deleted the LEFT character (i)
                // We check the rest of the string from (i + 1) to j
                int left1 = i + 1, right1 = j;
                boolean isPath1Valid = true;
                while (left1 < right1) {
                    if (str[left1] != str[right1]) {
                        isPath1Valid = false;
                        break;
                    }
                    left1++;
                    right1--;
                }
                
                // Path 2: Pretend we deleted the RIGHT character (j)
                // We check the rest of the string from i to (j - 1)
                int left2 = i, right2 = j - 1;
                boolean isPath2Valid = true;
                while (left2 < right2) {
                    if (str[left2] != str[right2]) {
                        isPath2Valid = false;
                        break;
                    }
                    left2++;
                    right2--;
                }
                
                // If either path turned out to be a perfect palindrome, we win!
                return isPath1Valid || isPath2Valid;
            }
        }
        
        return true;
    }
}