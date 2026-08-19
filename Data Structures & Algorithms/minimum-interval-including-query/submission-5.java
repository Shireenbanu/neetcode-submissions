class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int res[] = new int[queries.length];
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(getRange(a), getRange(b)));

        HashMap<Integer, Integer> map = new HashMap<>();

        int dupQueries[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            dupQueries[i] = queries[i];
        }
        Arrays.sort(queries);
        // System.out.println(Arrays.toString(queries));
        
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            
            while (j < intervals.length && (intervals[j][0] <= queries[i])) {
                // System.out.println("Adding: " + Arrays.toString(intervals[j]));
                pq.offer(intervals[j]);
                j++;
            }

            while ((pq.size() > 0) && (pq.peek()[0] > queries[i] || pq.peek()[1] < queries[i])) {
                pq.poll();
            }

            if (pq.size() > 0) {
                res[i] = getRange(pq.peek());
            } else
                res[i] = -1;

            // System.out.println(" Result for: " + Arrays.toString(pq.peek()) + " " + res[i]+ " queries[i] " + queries[i]);
            map.put(queries[i], res[i]);
        }

        for (int item = 0; item < dupQueries.length; item++) {
            res[item] = map.get(dupQueries[item]);
        }

        return res;
    }

    public int getRange(int ele[]) {
        // System.out.println("got called: " + Arrays.toString(ele)+ " res = "+((ele[1] - ele[0]) +
        // 1));
        return ((ele[1] - ele[0]) + 1);
    }
}
