class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        
        for (int i = 0; i <=n; i++) {
            int val = i;
            int count = 0;
            while (val > 0) {
                count = count + (val & 1);
                val = val >> 1;
            }
            arr[i] = count;
        }

        return arr;
    }
}
