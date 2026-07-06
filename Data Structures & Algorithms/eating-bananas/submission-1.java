class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int min = piles[0];

        for (int item : piles) {
            max = Math.max(max, item);
            min = Math.min(min, item);
        }

        // System.out.println(" max: " + max);
        // System.out.println(" min: " + min);

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            int hr = h;

            for (int item : piles) {
                int remHr = (int) Math.ceil((double) item / mid);
                hr = hr - remHr;
            }
            // System.out.println("hr: " + hr);

            if (hr < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
