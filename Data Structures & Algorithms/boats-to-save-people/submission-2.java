class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        
        // Step 2: Two-pointer approach
        while (left <= right) {
            // If the lightest and heaviest person can share a boat
            if (people[left] + people[right] <= limit) {
                left++; // Lightest person is paired, move pointer
            }
            // The heaviest person takes a boat regardless
            right--; 
            boats++;
        }
        
        return boats;
    }
}