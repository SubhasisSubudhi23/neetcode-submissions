
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // If the input is empty, return an empty list
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        // Map to store sorted string signature -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. Sort the string to create the signature
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String signature = new String(charArray);
            
            // 2. Add to the map
            // putIfAbsent is a clean way to ensure a list exists for the signature
            map.putIfAbsent(signature, new ArrayList<>());
            map.get(signature).add(s);
        }
        
        // 3. Return the values as a list of lists
        return new ArrayList<>(map.values());
    }
}