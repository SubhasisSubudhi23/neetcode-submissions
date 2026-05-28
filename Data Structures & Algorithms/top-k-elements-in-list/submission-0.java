class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for(i = 0; i < nums.length; i++){
             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = map.size(); 
        int[] key = new int[count];
        int[] value = new int[count];
        int index = 0;
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            key[index] = en.getKey();
            value[index] = en.getValue();
            index++;
        }
        for(i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) { 
                if (value[i] < value[j]) {
                    int t1 = value[j];
                    value[j] = value[i];
                    value[i] = t1;
                    int t2 = key[j];
                    key[j] = key[i];
                    key[i] = t2;
                }
            }            
        }
        int[] arr = new int[k];
        for(i = 0; i < k; i++){
            arr[i] = key[i];
        }        
        return arr;
    }
}