class Solution {
    public int[] maxSlidingWindow(int[] nums, int k1) {
        if (k1 == 1) {
            return nums;
        }

        int res[] = new int[nums.length - (k1-1)];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // maxHeap.offer(10);
        // maxHeap.offer(100);

        int i = 0;
        int start = 0;
        int indexing = 0;
        while (i <= nums.length) {
            // System.out.println(" i = " + i);
            if ((maxHeap.size() % k1) == 0 && i != 0) {
                // System.out.println("highest material: " + maxHeap.peek());
                res[indexing] = maxHeap.peek();
                maxHeap.remove(nums[start]);
                indexing++;
                start++;
            }

            if (i < nums.length) {
                maxHeap.offer(nums[i]);
            }
            i++;
        }

        return res;
    }
}
