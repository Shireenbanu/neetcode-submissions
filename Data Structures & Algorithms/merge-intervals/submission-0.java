class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // for (int[] items : intervals) System.out.println(" intervals: " + Arrays.toString(items));
        List<List<Integer>> list = new ArrayList<>();
        //   list.add(Arrays.asList(intervals[0][1], intervals[1][1]));

        int runner = 0;
        while (runner < intervals.length) {
            if (runner == 0) {
                list.add(Arrays.asList(intervals[runner][0], intervals[runner][1]));
                runner++;
            }

            List<Integer> itemArray = list.get(list.size() - 1);

            if (runner<intervals.length && itemArray.get(1) >= intervals[runner][0]) {
                while (runner < intervals.length && itemArray.get(1) >= intervals[runner][0]) {
                    // System.out.println(itemArray.get(1) + " is greater " + intervals[runner][0]);
                    itemArray.set(1, Math.max(itemArray.get(1), intervals[runner][1]));
                    runner++;
                }
            } else {
                list.add(Arrays.asList(intervals[runner][0], intervals[runner][1]));
                runner++;
            }

            // System.out.println("items: " + list);
        }
        int res[][] = new int[list.size()][2];
        int i = 0;
        for (List<Integer> item : list) {
            res[i][0] = item.get(0);
            res[i][1] = item.get(1);
            i++;
        }
        return res;
    }
}
