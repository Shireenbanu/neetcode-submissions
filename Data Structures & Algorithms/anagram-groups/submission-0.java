class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> res = new ArrayList<>();
       HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i =0; i<strs.length; i++){
            String curr = strs[i];
            char arr[] = curr.toCharArray();
            Arrays.sort(arr);
            StringBuilder sortedString = new StringBuilder();
            for(char item: arr){
                sortedString.append(item);
            }
            // System.out.println("arr: "+sortedString);
            String keyString = sortedString.toString();
            if(!map.containsKey(keyString)){
                List<String> arrForUnsortedString = new ArrayList<>();
                arrForUnsortedString.add(curr);
                map.put(keyString, arrForUnsortedString);
            }
            else
            {
               List<String> arrForUnsortedString = map.get(keyString);
               arrForUnsortedString.add(curr);
               map.put(keyString,arrForUnsortedString);
            }
        }

        for(Map.Entry<String,List<String>> item: map.entrySet()){
            // System.out.println("item: "+item);
            res.add(item.getValue());
        }
        
        // System.out.println("map: "+ map);        
       return res;
    }
}
