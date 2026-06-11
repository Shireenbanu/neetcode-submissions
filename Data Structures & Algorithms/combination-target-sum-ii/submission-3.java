class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recursiveComb(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    public boolean recursiveComb(
        List<List<Integer>> res, int arr[], int diff, int runningIndex, List<Integer> list) {
            // System.out.println("list: "+list + " diff "+ diff);

             if (diff<0) {
                // System.out.println("high:" + list);
                return false;
            }

            if (diff == 0) {
                res.add(list);
                // System.out.println("equal: " + list+ " diff "+runningIndex);
                // System.out.println("Match list: "+Arrays.toString(valDiff));
                return false;
            }

           
        boolean flag = true;
        for(int i=runningIndex; i<arr.length ;i++){
            // System.out.println("i = " + i);
            if((i>runningIndex && arr[i] == arr[i-1]) || (arr[i]>diff)){
                continue;
            }
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(arr[i]);  
            flag = recursiveComb(res, arr, diff - arr[i], i + 1, list2);
            if(!flag)
            break;
        }

        return true;
    }
}
