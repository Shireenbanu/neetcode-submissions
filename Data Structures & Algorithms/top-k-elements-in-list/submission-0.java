class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    int res[] = new int[k];
    HashMap<Integer, Integer> map = new HashMap<>();
   PriorityQueue<Map.Entry<Integer, Integer>> pq = 
    new PriorityQueue<>((a,b)->Integer.compare(b.getValue(), a.getValue()));

    for(int i=0; i<nums.length; i++){
        if(!(map.containsKey(nums[i]))){
            map.put(nums[i], 1);
        }
        else
        {
            int val = map.get(nums[i]);
            map.put(nums[i], val+1);
        }
    }

    pq.addAll(map.entrySet());
    // System.out.println(pq);
    
    for(int i =0; i<res.length; i++){
        Map.Entry<Integer,Integer> val = pq.poll();
        res[i] = val.getKey();
    }
 
    return res;
    }
}
