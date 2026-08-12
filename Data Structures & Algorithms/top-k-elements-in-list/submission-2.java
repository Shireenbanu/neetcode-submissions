class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res [] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));

        for (int item : nums) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                // System.out.println("get: "+ map.get(item)+1);
                map.put(item, map.get(item) + 1);
            }
        }
        

        for( HashMap.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(entry.getKey());
        }



        for(int i =0; i<k; i++){
            res[i] = pq.poll();
        }


        return res;
    }
}
