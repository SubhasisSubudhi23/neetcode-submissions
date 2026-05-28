class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Pattern: [Length] + [#] + [String]
            // Example: "Hello" -> "5#Hello"
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // 1. Find the delimiter starting from our current position i
            int delimiterPos = str.indexOf('#', i);
            
            // 2. The text between our start (i) and the '#' is the number
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            
            // 3. Move the pointer to the start of the actual string content
            // (One step past the '#')
            i = delimiterPos + 1;
            
            // 4. Extract exactly 'length' characters
            String word = str.substring(i, i + length);
            res.add(word);
            
            // 5. Jump the pointer i to the beginning of the next word's header
            i += length;
        }
        
        return res;
    }
}
