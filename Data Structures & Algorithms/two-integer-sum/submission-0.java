class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
         
         HashMap<Integer, List<Integer>> map = new HashMap<>();
        for( int i=0; i<nums.length; i++){
            List<Integer> list = new ArrayList<>();
         if(!(map.containsKey(nums[i]))){
            list.add(i);
            map.put(nums[i],list);
         }
         else
         {
            List<Integer> oldList = map.get(nums[i]);
            oldList.add(i);
            map.put(nums[i], oldList);
         }
        //    System.out.println("map: "+ map);
            
        }

        for(int i = 0; i<nums.length; i++){
            int find = target - nums[i];
            if(map.containsKey(find)){
                List<Integer> list = map.get(find);
                if(find == nums[i] && list.size()>1){
                   
                    for(Integer item: list){
                        if(item != i){
                            if(item<i){
                                res[0] = item;
                                res[1] = i;
                            }
                            else
                            {
                            res[0] = i;
                            res[1] = item;
                            }
                        }
                    }
                   
                }
                else
                {
                    int item = list.get(0);
                      if(item<i){
                                res[0] = item;
                                res[1] = i;
                            }
                            else
                            {
                            res[0] = i;
                            res[1] = item;
                            }
                }

            }
        }

        return res;
    }
}
