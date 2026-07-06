class Solution {
    public int lastStoneWeight(int[] stones) {
        int res = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        if(stones.length == 1){
            return stones[0];
        }
        for (int item : stones) {
            pq.offer(item);
        }
        while (pq.size() > 1) {
            int item1 = pq.poll();
            int item2 = pq.poll();
             res = Math.abs(item1 - item2);
            // System.out.println("res: " + res);
            if (res != 0) {
                pq.offer(res);
            }
        }
        // System.out.println("pq: " + pq.poll());
        if(pq.size()>0){
            return pq.poll();
        }
        return 0;
    }
}
