
class Solution {
    public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int n = s.length();
        
        // Our map to track character frequencies inside the window
        HashMap<Character, Integer> map = new HashMap<>();
        
        int l = 0, r = 0;
        int max = 0; // Tracks our maximum valid window length

        while (r < n) {
            // 1. Expand: Add current character to our map
            map.put(str[r], map.getOrDefault(str[r], 0) + 1);
            
            // 2. Track Dominant: Scan the map to find the highest frequency
            int maxCount = 0;
            for (int frequency : map.values()) {
                maxCount = Math.max(maxCount, frequency);
            }
            
            // 3. Shrink: While the window is invalid, squeeze from the left
            while ((r - l + 1) - maxCount > k) {
                map.put(str[l], map.get(str[l]) - 1); // Decrease inventory
                l++; // Shrink window
            }
            
            // 4. Update Record: Save the longest valid window length found so far
            max = Math.max(max, r - l + 1);
            
            // 5. Move Right: Expand the window for the next iteration
            r++;
        }
        
        return max;
    }
}